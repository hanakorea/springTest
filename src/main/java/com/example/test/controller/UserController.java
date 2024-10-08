package com.example.test.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.test.domain.User;
import com.example.test.service.UserService;

@Controller
public class UserController {
	
	@GetMapping("/signup")
	public String signup() {
		return "/user/signup";
	}
	
	@Autowired
	private UserService userService;
	
	@PostMapping("/user")
	public String insertUser(User user) {
		userService.insertUser(user);
		
		return "redirect:/";
	}
	
	@GetMapping("/idcheck")
	@ResponseBody //처리된결과, 보낼 메세지등은 꼭 어노테이션
	public int idCheck(String username) {
		int result = userService.idCheck(username);
		
		return result;
	}
	
	@GetMapping("/login")
	public String loginPage() {
		return "user/login";
	}
	
	@PostMapping("/login")
	public String login(String username, String password, HttpSession session, Model model) {
		User user = userService.getUser(username);
		// and, or연산은 앞부터 처리 그래서 이걸 파악하는게 중요
		if(user != null && user.getUsername().equals(username) && user.getPassword().equals(password)) {	
			session.setAttribute("principal", user);
			return "redirect:/";
		}else {
			model.addAttribute("msg", "입력하신 정보가 일치하지 않습니다.");
			return "user/login";
		}
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		
		return "redirect:/";
	}
}
