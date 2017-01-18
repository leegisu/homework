package com.example.web;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;

@Controller
@RequestMapping("/user")
public class userController {
	
	
	private static final Logger log = LoggerFactory.getLogger(userController.class);

	
	private List<User> users = new ArrayList<>();

	@PostMapping("/create")
	public String create(User user) {

		users.add(user);
		
		log.info("users size : " + users.size());
		log.debug("users : " + users);
		
		
//		for (User u : users) {
//			System.out.println("users : " + u);
//		}
		//return "redirect:/";
		return "redirect:/user/list2";

	}

	@GetMapping("/list2")
	public String list(Model model) {

		model.addAttribute("users", users); // list값 , 넘겼을때 이름

		return "/user/list";
	}

}
