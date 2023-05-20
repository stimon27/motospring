package me.dev.motospring.controllers;

import me.dev.motospring.services.RacingTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

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
}
