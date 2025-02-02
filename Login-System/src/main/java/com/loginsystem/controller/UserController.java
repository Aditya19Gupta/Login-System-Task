package com.loginsystem.controller;


import com.loginsystem.entities.User;
import com.loginsystem.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {
	
	@Autowired
	private UserRepo repo;
	@Autowired
	private BCryptPasswordEncoder encoder;
	
	@GetMapping("/home")
	public String getHome(Model m) {
		
		m.addAttribute("title","LoginSystem- Home");
		return "home";
	}
	
	//signup
	@GetMapping("/register")
	public String getSignup(Model m) {
		
		m.addAttribute("title","LoginSystem- Register");
		m.addAttribute("user",new User());
		return "signup";
	}
	
	@PostMapping("/register-process")
	public String signupProcess(@ModelAttribute("user") User user ) {
		try {
			user.setRole("ROLE_USER");
			user.setPassword(encoder.encode(user.getPassword()));
			user.setId(2);
			repo.save(user);
			System.out.println(user);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "signup";
	}
	
	//signup end
	@GetMapping("/signin")
	public String getSignin(Model m) {
		
		m.addAttribute("title","LoginSystem- Login");
		return "login";
	}
	
	
}
