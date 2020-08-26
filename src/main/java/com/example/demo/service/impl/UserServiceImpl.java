package com.example.demo.service.impl;

import com.example.demo.dao.UserMapper;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User selectUserByTicket(String ticket) {
        return null;
    }

    @Override
    public Map<String, Object> register(User user) {
        return null;
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        return null;
    }

    @Override
    public void logout(String ticket) {

    }
}
