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
import com.example.demo.util.ImsUtil;
import org.apache.commons.lang3.StringUtils;
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
        Map<String, Object> result = new HashMap<String, Object>();
        LoginTicket loginTicket = ticketMapper.selectByTicket(ticket);
        if(loginTicket != null) {
            int status = loginTicket.getStatus();
            if (status == 0) {//登录凭据有效 todo:用户停用应该触发登录凭据自动失效
                User user = userMapper.selectById(loginTicket.getUserId());
               result.put("user",user);
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
        Map<String, Object> map = new HashMap<>();

        // 空值处理
        if (StringUtils.isBlank(username)) {
            map.put("usernameMsg", "账号不能为空!");
            return map;
        }
        if (StringUtils.isBlank(password)) {
            map.put("passwordMsg", "密码不能为空!");
            return map;
        }

        // 验证账号
        User user = userMapper.selectByName(username);
        if (user == null) {
            map.put("usernameMsg", "该账号不存在!");
            return map;
        }

        // 验证状态
        if (user.getStatus() == 1) {
            map.put("usernameMsg", "该账号已停用!");
            return map;
        }

        // 验证密码
        if (!user.getPassword().equals(password)) {
            map.put("passwordMsg", "密码不正确!");
            return map;
        }

        // 生成登录凭证
        LoginTicket loginTicket = new LoginTicket();
        loginTicket.setUserId(user.getId());
        loginTicket.setTicket(ImsUtil.generateUUID());
        loginTicket.setStatus(0);
        ticketMapper.insertLoginTicket(loginTicket);
        map.put("ticket", loginTicket.getTicket());
        return map;
    }

    @Override
    public void logout(String ticket) {

    }
}
