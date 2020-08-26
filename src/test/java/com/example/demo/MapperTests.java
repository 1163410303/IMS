package com.example.demo;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.assertj.core.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class MapperTests {

    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(1);
        System.out.println(user);

        System.out.println(userMapper.selectByName("wang"));
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setUsername("wang");
        user.setPassword("123");
        user.setStatus(0);
        int rows = userMapper.insertUser(user);

        System.out.println(rows);
        System.out.println(user.getId());

    }
}
