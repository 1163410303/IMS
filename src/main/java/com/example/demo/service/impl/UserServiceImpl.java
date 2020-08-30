package com.example.demo.service.impl;

import com.example.demo.dao.StudentMapper;
import com.example.demo.dao.TeacherMapper;
import com.example.demo.dao.TicketMapper;
import com.example.demo.dao.UserMapper;
import com.example.demo.entity.LoginTicket;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private StudentMapper studentMapper;

    @Autowired
    private TeacherMapper teacherMapper;

    @Autowired
    private TicketMapper ticketMapper;

    /**
     *根据客户端登录凭据来获得用户当前的状态
     * @param ticket
     * @return
     */
    @Override
    public Map<String, Object> selectUserByTicket(String ticket) {
        Map<String, Object> result = new HashMap<>();
        LoginTicket loginTicket = ticketMapper.selectByTicket(ticket);
        if(loginTicket != null) {
            int status = loginTicket.getStatus();
            if (status == 0) {//登录凭据有效
                User user = userMapper.selectById(loginTicket.getUserId());
                if (user.getStatus() == 0){
                    result.put("msg", "登录凭证存在且有效,用户存在且已登录");
                    result.put("userInfo", user);
                }
                else {
                    result.put("msg","用户已停用，需要注册");
                    result.put("userInfo", user);
                }
            } else if (status == 1) {
                result.put("msg", "登录凭据已经失效需要登录");
            }
        }else{
            result.put("msg", "登录凭据不存在");
        }
        return result;
    }

    @Override
    public Map<String, Object> register(User user) {
        Map<String, Object> map = new HashMap<>();
        userMapper.insertUser(user);
        return map;
    }

    @Override
    public Map<String, Object> registerTeacher(Teacher teacher) {
        Map<String, Object> map = new HashMap<>();
        userMapper.insertUser(teacher);
        teacherMapper.insertTeacher(teacher);
        return map;
    }

    @Override
    public Map<String, Object> registerStudent(Student student) {
        Map<String, Object> map = new HashMap<>();

        return map;
    }

    @Override
    public Map<String, Object> login(String username, String password) {
        return null;
    }

    @Override
    public void logout(String ticket) {

    }
}
