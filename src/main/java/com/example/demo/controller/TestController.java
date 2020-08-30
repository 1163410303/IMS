package com.example.demo.controller;

import com.example.demo.annotation.LoginRequired;
import com.example.demo.entity.Student;
import com.example.demo.service.UserService;
import com.sun.xml.internal.bind.v2.TODO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
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

	@GetMapping("/student/{id}")
	public Map<String,Object> getStudentById(){
		Map<String, Object> map = new HashMap<>();
		
		return map;
	}

	@PostMapping("/student")
	public Map<String,Object> registerStudent(@RequestBody Student student){
		Map<String,Object> map = new HashMap<>();


		return map;
	}

	/**
	 *todo 1.完成API文档，并填写controller层 测试API并继续完善Mapperservice，实现简单的业务逻辑
	 * 2 使用postman和junit测试
	 *todo 完成用例图，完成类图，完成时序图
	 * 并把计算器的文档放到PPt里还有整理的全部的学习资料
	 *
	 */




}
