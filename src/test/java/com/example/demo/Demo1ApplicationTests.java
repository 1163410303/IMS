package com.example.demo;

import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import java.util.HashMap;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class Demo1ApplicationTests {

	@LocalServerPort
	private int port;

	@Autowired
	private TestRestTemplate restTemplate;

	@Test
	void contextLoads() {
	}

	@Test
	void testLogin() {
		String requestResult = this.restTemplate.getForObject("http://127.0.0.1:" + port + "/test/hello",
				String.class);
		System.out.println(requestResult);
		Assertions.assertThat(requestResult).contains("login");
	}

	@Test
	void testRegister() {
		User user = new User();
		user.setUsername("testRegister");
		user.setStatus(0);
		user.setPassword("123");
		HashMap requestResult = this.restTemplate.postForObject("http://127.0.0.1:" + port + "/test/user", user, HashMap.class);
		System.out.println(requestResult);
		Assertions.assertThat(requestResult).containsValues("注册成功");
	}


}
