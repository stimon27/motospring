package me.dev.motospring.controllers;

import me.dev.motospring.services.RacingTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/racingteams")
public class RacingTeamController {
    private final RacingTeamService racingTeamService;

    public RacingTeamController(RacingTeamService racingTeamService) {
        this.racingTeamService = racingTeamService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listRacingTeams(Model model) {
        model.addAttribute("racingteams", racingTeamService.findAll());
        return "racingTeams/index";
    }

    @RequestMapping("/find")
    public String findRacingTeams() {
        return "notimplemented";
    }

    @GetMapping("/{racingTeamId}")
    public ModelAndView showRacingTeam(@PathVariable("racingTeamId") Long racingTeamId) {
        ModelAndView mav = new ModelAndView("/racingTeams/racingTeamDetails");
        mav.addObject(racingTeamService.findById(racingTeamId));
        return mav;
    }
}
