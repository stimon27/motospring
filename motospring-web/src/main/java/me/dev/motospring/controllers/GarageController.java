package me.dev.motospring.controllers;

import me.dev.motospring.services.GarageService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/garages")
public class GarageController {
    private final GarageService garageService;

    public GarageController(GarageService garageService) {
        this.garageService = garageService;
    }

    @RequestMapping({"", "/", "/index", "/index.html"})
    String listGarages(Model model) {
        model.addAttribute("garages", garageService.findAll());

        return "garages/index";
    }
}
