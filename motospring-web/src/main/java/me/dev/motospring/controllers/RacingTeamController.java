package me.dev.motospring.controllers;

import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.RacingTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

@Controller
@RequestMapping("/racingteams")
public class RacingTeamController {
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
        // allow parameterless GET request for /racingteams to return all records
        if (racingTeam.getName() == null) {
            racingTeam.setName(""); // empty string signifies broadest possible search
        }

        // find racing teams by name
        List<RacingTeam> results = racingTeamService.findAllByNameLike(racingTeam.getName());
        if (results.isEmpty()) {
            // no racing teams found
            result.rejectValue("name", "notFound", "not found");
            return "racingTeams/findRacingTeams";
        } else if (results.size() == 1) {
            // 1 racing team found
            racingTeam = results.iterator().next();
            return "redirect:/racingteams/" + racingTeam.getId();
        } else {
            // multiple owners found
            model.addAttribute("selections", results);
            return "racingTeams/racingTeamsList";
        }
    }

    @GetMapping("/{racingTeamId}")
    public ModelAndView showRacingTeam(@PathVariable("racingTeamId") Long racingTeamId) {
        ModelAndView mav = new ModelAndView("/racingTeams/racingTeamDetails");
        mav.addObject(racingTeamService.findById(racingTeamId));
        return mav;
    }
}
