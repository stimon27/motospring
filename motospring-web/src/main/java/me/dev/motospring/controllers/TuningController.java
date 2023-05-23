package me.dev.motospring.controllers;

import me.dev.motospring.model.Car;
import me.dev.motospring.model.Tuning;
import me.dev.motospring.services.CarService;
import me.dev.motospring.services.TuningService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
public class TuningController {
    private final TuningService tuningService;
    private final CarService carService;

    public TuningController(TuningService tuningService, CarService carService) {
        this.tuningService = tuningService;
        this.carService = carService;
    }

    @InitBinder
    public void setAllowedFields(WebDataBinder dataBinder) {
        dataBinder.setDisallowedFields("id");
    }

    @ModelAttribute("tuning")
    public Tuning loadCarWithTuning(@PathVariable("carId") Long carId, Model model) {
        Car car = carService.findById(carId);
        model.addAttribute("car", car);
        Tuning tuning = new Tuning();
        car.getTunings().add(tuning);
        tuning.setCar(car);
        return tuning;
    }

    @GetMapping("/racingteams/*/cars/{carId}/tunings/new")
    public String initNewTuningForm(@PathVariable("carId") Long carId, Model model) {
        System.out.println("Hello");
        return "cars/createOrUpdateTuningForm";
    }

    @PostMapping("/racingteams/{racingTeamId}/cars/{carId}/tunings/new")
    public String processNewTuningForm(@Valid Tuning tuning, BindingResult result) {
        if (result.hasErrors()) {
            return "cars/createOrUpdateTuningForm";
        } else {
            tuningService.save(tuning);
            return "redirect:/racingteams/{racingTeamId}";
        }
    }
}
