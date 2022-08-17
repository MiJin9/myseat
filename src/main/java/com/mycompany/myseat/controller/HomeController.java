package com.mycompany.myseat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.Locale;

@Controller
public class HomeController {
		
	@GetMapping("/")
	public String home(Locale locale, Model model, HttpSession session)throws Exception {
		
		return "index.tiles";
	}

}
