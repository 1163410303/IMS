package com.example.demo.service;

import java.util.Map;

import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;


public interface UserService {

    /**
     * 根据本地ticket获取用户登录状态
     * @param ticket
     * @return  user
     */
    Map<String, Object> selectUserByTicket(String ticket);

    /**
     * 注册
     * @param user
     * @return
     */
    Map<String,Object> register(User user);

    /**
     * 注册教师
     * @param teacher
     * @return
     */
    Map<String,Object> registerTeacher(Teacher teacher);

    /**
     * 注册学生
     * @param student
     * @return
     */
    Map<String,Object> registerStudent(Student student);

    /**
     * 登录
     * @param username
     * @param password
     * @return
     */
    Map<String, Object> login(String username, String password);

    /**
     * 登出
     * @param ticket
     */
    void logout(String ticket);


}
