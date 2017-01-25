package com.example.web;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.domain.UserRepository;
import com.example.domain.Question;
import com.example.domain.WriterRepository;
import com.example.utils.HttpSessionUtils;

@Controller
public class qnaController {

	private static final Logger log = LoggerFactory.getLogger(userController.class);

	
	@Autowired
	private WriterRepository writerRepository;
	
	//private List<Writer> writers = new ArrayList<>();

	@RequestMapping("qna/qnapage")
	public String qna(){
		return "qna/form";
	}
	
	@PostMapping("/qna/questions")
	public String create(Question writer) {
		log.debug(writer.toString());
	//	writers.add(writer);
		writerRepository.save(writer);
		

		// for (User u : users) {
		// System.out.println("users : " + u);
		// }
		// return "redirect:/";
		return "redirect:/";

	}

	@GetMapping("/")
	 public String list(Model model) {
	
	 model.addAttribute("writers", writerRepository.findAll()); // list값 , 넘겼을때 이름
	 	
	 return "/qna/index";
	 }
	
	@GetMapping("/qna/form")
	public String form(){
		
		return "/qna/form";
	}
	
	@GetMapping("/qna/show")
	public String show(){
		
		return "/qna/show";
	}
}



