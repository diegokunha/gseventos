package br.com.gseventos.gseventos.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class GSEventosController {

	@GetMapping("/")
	public String index() {
		return "/index";
	}
	
}
