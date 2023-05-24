package me.dev.motospring.controllers;

import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.RacingTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/racingteams")
public class RacingTeamController {
    private static final String VIEWS_RACING_TEAM_CREATE_OR_UPDATE_FORM = "racingTeams/createOrUpdateRacingTeamForm";

    private final RacingTeamService racingTeamService;

    public RacingTeamController(RacingTeamService racingTeamService) {
        this.racingTeamService = racingTeamService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @RequestMapping("/find")
    public String findRacingTeams(Model model) {
        model.addAttribute("racingTeam", RacingTeam.builder().build());
        return "racingTeams/findRacingTeams";
    }

    @GetMapping
    public String processFindForm(RacingTeam racingTeam, BindingResult result, Model model) {
        if (racingTeam.getName() == null) {
            racingTeam.setName(""); // empty string signifies broadest possible search
        }
        List<RacingTeam> results = racingTeamService.findAllByNameLike("%" + racingTeam.getName() + "%");
        if (results.isEmpty()) {
            result.rejectValue("name", "notFound", "not found");
            return "racingTeams/findRacingTeams";
        } else if (results.size() == 1) {
            racingTeam = results.iterator().next();
            return "redirect:/racingteams/" + racingTeam.getId();
        } else {
            model.addAttribute("selections", results);
            return "racingTeams/racingTeamsList";
        }
    }

    @GetMapping("/{racingTeamId}")
    public String showRacingTeam(@PathVariable Long racingTeamId, Model model) {
        model.addAttribute("racingTeam", racingTeamService.findById(racingTeamId));
        return "racingTeams/racingTeamDetails";
    }

    @GetMapping("/new")
    public String initCreationForm(Model model) {
        model.addAttribute("racingTeam", RacingTeam.builder().build());
        return VIEWS_RACING_TEAM_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/new")
    public String processCreationForm(@Valid RacingTeam racingTeam, BindingResult result) {
        if (result.hasErrors()) {
            return VIEWS_RACING_TEAM_CREATE_OR_UPDATE_FORM;
        }

        RacingTeam savedRacingTeam = racingTeamService.save(racingTeam);
        return "redirect:/racingteams/" + savedRacingTeam.getId();
    }

    @GetMapping("/{racingTeamId}/edit")
    public String initUpdateRacingTeamForm(@PathVariable Long racingTeamId, Model model) {
        model.addAttribute(racingTeamService.findById(racingTeamId));
        return VIEWS_RACING_TEAM_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/{racingTeamId}/edit")
    public String processUpdateRacingTeamForm(@Valid RacingTeam racingTeam, BindingResult result,
                                         @PathVariable Long racingTeamId) {
        if (result.hasErrors()) {
            return VIEWS_RACING_TEAM_CREATE_OR_UPDATE_FORM;
        }

        racingTeam.setId(racingTeamId);
        RacingTeam savedRacingTeam = racingTeamService.save(racingTeam);
        return "redirect:/racingteams/" + savedRacingTeam.getId();
    }
}
