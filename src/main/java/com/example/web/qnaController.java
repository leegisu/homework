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

import com.example.domain.Writer;

@Controller
public class qnaController {

	private static final Logger log = LoggerFactory.getLogger(userController.class);

	private List<Writer> writers = new ArrayList<>();

	@PostMapping("qna/questions")
	public String create(Writer writer) {

		writers.add(writer);

		log.info("users size : " + writers.size());
		log.debug("users : " + writers);

		// for (User u : users) {
		// System.out.println("users : " + u);
		// }
		// return "redirect:/";
		return "redirect:/";

	}

	@GetMapping("/")
	 public String list(Model model) {
	
	 model.addAttribute("writers", writers); // list값 , 넘겼을때 이름
	
	 return "/qna/index";
	 }

}


