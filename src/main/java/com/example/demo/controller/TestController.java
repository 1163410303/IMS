package com.example.demo.controller;

import com.example.demo.annotation.LoginRequired;
import com.example.demo.entity.Lesson;
import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import com.example.demo.util.ImsUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

@RestController
public class TestController {

	@Autowired
	private UserService userService;

	@Value("${server.servlet.context-path}")
	private String contextPath;

	@LoginRequired
	@GetMapping("/hello")
	public String index() {
		return "hello world01";
	}

//	@LoginRequired
	@GetMapping("/lessons")
	public String getlessons() {
		Map<String,Object> map = new HashMap<>();
		for(int i = 0;i < 1000; i++){
			map.put(""+i, new Lesson(i,"数学"+i, 1234, "6.5"));
		}
		return ImsUtil.getJSONString(0,"success", map);
	}

	@GetMapping("/login")
	public String login() {
		String msg = "请先登录来获取凭证";
		return msg;
	}
	@PostMapping("/login")
	public String login(@RequestBody User user, HttpSession session, HttpServletResponse response) {
		String username = user.getUsername();
		String password = user.getPassword();
		Map<String,Object> result = userService.login(username,password);
		if (result.containsKey("ticket")) {
			Cookie cookie = new Cookie("ticket", result.get("ticket").toString());
			cookie.setPath(contextPath);
			response.addCookie(cookie);
		}
		return ImsUtil.getJSONString(0,"success", result);
	}

	@GetMapping("/student/{id}")
	public String getStudentById(@PathVariable Integer id){

		
		return ImsUtil.getJSONString(0,"");
	}

	@PostMapping("/student")
	public String registerStudent(@RequestBody Student student){
		userService.registerStudent(student);
		String result = ImsUtil.getJSONString(0);
		return result;
	}

	/**
	 *todo 1.完成API文档，并填写controller层 测试API并继续完善Mapperservice，实现简单的业务逻辑
	 * 2 使用postman和junit测试
	 *todo 完成用例图，完成类图，完成时序图
	 * 并把计算器的文档放到PPt里还有整理的全部的学习资料
	 */




}
