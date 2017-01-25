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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.User;
import com.example.domain.UserRepository;
import com.example.utils.HttpSessionUtils;

@Controller
@RequestMapping("/users")
public class userController {

	private static final Logger log = LoggerFactory.getLogger(userController.class);

	// private List<User> users = new ArrayList<>();

	@Autowired
	private UserRepository userRepository;

	@PostMapping("/logincheck")
	public String login(String userId, String password, HttpSession session) {

		User user = userRepository.findByuserId(userId);

		if (user == null) {
			log.info("로그인 실패1");
			return "redirect:/users/login.html";
		}

		if (!user.matchPassword(password)) {
			log.info("로그인 실패2");
			return "redirect:/users/login.html";
		}

		log.info("로그인 성공");

		session.setAttribute("loginUser", user); // Key/Value :: 세션에다가 user데이터를
													// 다 넣음

		return "redirect:/"; // 설정
	}
	
	@PostMapping("/create")
	public String create(User user) {

		userRepository.save(user); // db에 넣기
		// users.add(user);

		// log.info("users size : " + users.size());
		// log.debug("users : " + users);

		return "redirect:/user/list2";

	}

	@PutMapping("/{id}/update")
	public String update(@PathVariable Long id, User user, HttpSession session) {

		Object temp = session.getAttribute("loginUser");

		checkOwner(id, session);

		User dbUser = userRepository.findOne(id);

		dbUser.update(user);

		// userRepository.save(dbUser);

		return "/users/updateForm";

	}

	@GetMapping("/{id}/form")
	public String updateForm(@PathVariable Long id, Model model, HttpSession session) {

		Object temp = session.getAttribute("loginUser");

		checkOwner(id, session);

		model.addAttribute("user", userRepository.findOne(id));

		return "/users/updateForm";
	}

	private void checkOwner(Long id, HttpSession session) {
		
		if (!HttpSessionUtils.isLoginUser(session)) {
			throw new IllegalStateException("로그인하지 않은 사용자");
		}

		User loginUser = HttpSessionUtils.getUserFromSession(session);

		if (!loginUser.matchId(id)) {
			throw new IllegalStateException("다른 사용자 정보를 수정할 수 없습니다.");
		}
	}

	@GetMapping("/list2")
	public String list(Model model) {

		model.addAttribute("users", userRepository.findAll()); // 넘기는값(key) ,
																// 넣을값(Value)

		return "/users/list";
	}
	

	@GetMapping("/form")
	public String form() {

		return "/users/form";
	}

	@GetMapping("/profile")
	public String profile() {

		return "/users/profile";
	}

	@GetMapping("/login")
	public String login() {

		return "/users/login";
	}

	@GetMapping("/login_filed")
	public String login_filed() {

		return "/users/login_filed";
	}

	

}
