package com.mycompany.myseat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/place")
public class PlaceController {

    @Value("#{props['mapKey']}")
    private String mapKey;

    @Value("#{props['restKey']}")
    private String restKey;

    @GetMapping("/map")
    public String showMap(Model m){
        m.addAttribute("mapKey", mapKey);
        m.addAttribute("restKey", restKey);
        return "place/placeMap.tiles";
    }
}
