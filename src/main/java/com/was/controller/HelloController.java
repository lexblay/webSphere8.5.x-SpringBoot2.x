package com.was.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

	@RequestMapping("/")
	public String index() {
		return "Hola mundo spring";
	}
	
	
	@RequestMapping("/mundo")
	public String cadena() {
		return "Si funciona con las librerias";
	}
}
