package me.dev.motospring.controllers;

import me.dev.motospring.model.Car;
import me.dev.motospring.model.Make;
import me.dev.motospring.model.RacingTeam;
import me.dev.motospring.services.CarService;
import me.dev.motospring.services.MakeService;
import me.dev.motospring.services.RacingTeamService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Collection;

@Controller
@RequestMapping("/racingteams/{racingTeamId}")
public class CarController {

    private static final String VIEWS_CARS_CREATE_OR_UPDATE_FORM = "cars/createOrUpdateCarForm";
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
    public void initRacingTeamBinder(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @GetMapping("/cars/new")
    public String initCreationForm(RacingTeam racingTeam, Model model) {
        Car car = new Car();
        car.setRacingTeam(racingTeam);
        racingTeam.getCars().add(car);
        model.addAttribute("car", car);
        return VIEWS_CARS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/cars/new")
    public String processCreationForm(RacingTeam racingTeam, @Valid Car car, BindingResult result, Model model) {
        if (StringUtils.hasLength(car.getModel()) && car.isNew() && racingTeam.searchCar(car.getModel(), true) != null) {
            result.rejectValue("name", "duplicate", "already exists");
        }

        racingTeam.getCars().add(car);
        if (result.hasErrors()) {
            model.addAttribute("car", car);
            return VIEWS_CARS_CREATE_OR_UPDATE_FORM;
        }

        carService.save(car);
        return "redirect:/racingteams/" + racingTeam.getId();
    }

    @GetMapping("/cars/{carId}/edit")
    public String initUpdateForm(@PathVariable Long carId, Model model) {
        model.addAttribute("car", carService.findById(carId));
        return VIEWS_CARS_CREATE_OR_UPDATE_FORM;
    }

    @PostMapping("/cars/{carId}/edit")
    public String processUpdateForm(@Valid Car car, BindingResult result, RacingTeam racingTeam, Model model) {
        if (result.hasErrors()) {
            car.setRacingTeam(racingTeam);
            model.addAttribute("car", car);
            return VIEWS_CARS_CREATE_OR_UPDATE_FORM;
        }

        racingTeam.addCar(car);
        carService.save(car);
        return "redirect:/racingteams/{racingTeamId}";
    }

}
