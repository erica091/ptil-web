package com.pactera.ptil.web.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class PageController {

	@GetMapping("/index")
	public String index() {
		return "modules";
	}
	
    @GetMapping("/pets")
    public String catPage(HttpServletRequest request) {
        return "pets";
    }
    
    @GetMapping("/weather")
    public String weatherPage(HttpServletRequest request) {
        return "weather";
    }
}
