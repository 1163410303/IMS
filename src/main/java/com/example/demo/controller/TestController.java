package com.example.demo.controller;

import com.example.demo.annotation.LoginRequired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

	@LoginRequired
	@GetMapping("/hello")
	public String index() {
		return "hello world01";
	}

	@GetMapping("/login")
	public String login() {
		return "You need to login";
	}




}
