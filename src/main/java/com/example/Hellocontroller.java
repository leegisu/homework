package com.example;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class Hellocontroller {
	@GetMapping("/hello")
	public String hello(String name, Model model, int age) {

		System.out.println("name " + name);
		System.out.println("age" + age);

		model.addAttribute("name", name);
		model.addAttribute("age", age);

				
		return "hellohtml";
	}

}
