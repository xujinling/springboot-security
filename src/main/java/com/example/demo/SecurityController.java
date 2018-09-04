package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class SecurityController {

	@Autowired
	private StuRepository stuRepository;
	
	@RequestMapping(value="/login")
	public String toLogin(){
		return "/login";
	}
	
	@RequestMapping(value="/index")
	public String toIndex(){
		return "index";
	}
	
}
