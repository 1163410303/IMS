package com.example.demo;

import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class ServiceTests {
    @Autowired
    UserService userService;

    @Test
    public void testUserService(){
        Map<String, Object> map = userService.selectUserByTicket("test123");
        System.out.println(map);
    }
    @Test
    public void testLessonService(){
        Map<String, Object> map = userService.selectUserByTicket("test123");
        Map<String, Object> map1 = userService.selectUserByTicket("test123");
        Map<String, Object> map2 = userService.selectUserByTicket("test123");
        Map<String, Object> map3 = userService.selectUserByTicket("test123");
        Map<String, Object> map4 = userService.selectUserByTicket("test123");
        System.out.println(map);
    }

}
