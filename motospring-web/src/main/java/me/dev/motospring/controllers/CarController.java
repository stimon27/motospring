package me.dev.motospring.controllers;

import me.dev.motospring.model.Make;
import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.CarService;
import me.dev.motospring.services.MakeService;
import me.dev.motospring.services.RacingTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

@Controller
@RequestMapping("/racingteams/{racingTeamId}")
public class CarController {
    private final CarService carService;
    private final RacingTeamService racingTeamService;
    private final MakeService makeService;

    public CarController(CarService carService, RacingTeamService racingTeamService, MakeService makeService) {
        this.carService = carService;
        this.racingTeamService = racingTeamService;
        this.makeService = makeService;
    }

    @ModelAttribute("makes")
    public Collection<Make> populateMakes() {
        return makeService.findAll();
    }

    @ModelAttribute("racingTeam")
    public RacingTeam findRacingTeam(@PathVariable Long racingTeamId) {
        return racingTeamService.findById(racingTeamId);
    }

    @InitBinder("racingTeam")
    public void initOwnerBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }
}
