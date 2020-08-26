package com.example.demo.controller;

import com.example.demo.annotation.LoginRequired;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

	@Autowired
	private UserService userService;

	@LoginRequired
	@GetMapping("/hello")
	public String index() {
		return "hello world01";
	}

	@GetMapping("/login")
	public String login() {
		Map<String, Object> result = new HashMap<>();
		result = userService.login("wang","123");
		String msg = (String) result.get("msg");
		return msg;
	}




}
