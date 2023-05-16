package me.dev.motospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/racingteams")
public class RacingTeamController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    public String listRacingTeams() {
        return "racingTeams/index";
    }
}
