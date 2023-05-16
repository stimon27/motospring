package me.dev.motospring.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/garages")
public class GarageController {

    @RequestMapping({"", "/", "/index", "/index.html"})
    String listGarages() {
        return "garages/index";
    }
}
