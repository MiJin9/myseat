package com.mycompany.myseat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/review")
public class reviewController {

    @GetMapping("/list")
    public String goList(){
        return "review/reviewList.tiles";
    }

    @GetMapping("/write")
    public String writeReview(){
        return "review/review.tiles";
    }
}
