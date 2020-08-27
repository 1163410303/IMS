package com.example.demo;

import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.TicketMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.LoginTicket;
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

    @Autowired
    private TicketMapper ticketMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Test
    public void testSelectUser() {
        User user = userMapper.selectById(1);
        System.out.println(user);

        System.out.println(userMapper.selectByName("wang"));
    }

    @Test
    public void testInsertUser() {
        User user = new User();
        user.setUsername("wang");
        user.setPassword("123");
        user.setStatus(0);
        int rows = userMapper.insertUser(user);

        System.out.println(rows);
        System.out.println(user.getId());
    }

    /**
     * 登录凭据CRUD
     */
    @Test
    public void testInsertLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(101);
        loginTicket.setStatus(0);
        loginTicket.setTicket("test");

        int rows = ticketMapper.insertLoginTicket(loginTicket);
        System.out.println(rows);
        System.out.println(loginTicket.getId());
    }

    @Test
    public void testSelectLoginTicket() {
        LoginTicket loginTicket = new LoginTicket();
        loginTicket = ticketMapper.selectByTicket("test");
        System.out.println(loginTicket);
        System.out.println(loginTicket.getId());
    }

    @Test
    public void testUpdateLoginTicket() {

        int rows = ticketMapper.updateStatus("test", 1);
        System.out.println(rows);
    }


}
