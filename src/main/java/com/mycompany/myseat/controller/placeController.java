package com.mycompany.myseat.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/place")
public class placeController {


    @Value("#{props['mapKey']}")
    private String key;

    @GetMapping("/map")
    public String showMap(Model m){
        m.addAttribute("key", key);
        return "place/placeMap.tiles";
    }
}
