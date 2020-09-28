package com.example.demo.dao;

import com.example.demo.dao.*;
import com.example.demo.entity.LoginTicket;
import com.example.demo.entity.Student;
import com.example.demo.entity.Teacher;
import com.example.demo.entity.User;
import com.example.demo.entity.Class;
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

        System.out.println(userMapper.selectById(101));
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
        loginTicket = ticketMapper.selectByTicket("test123");
        System.out.println(loginTicket);
        System.out.println(loginTicket.getId());
    }

    @Test
    public void testUpdateLoginTicket() {

        int rows = ticketMapper.updateStatus("test", 1);
        System.out.println(rows);
    }

    /**
     * test StudentMapper
     */
    @Test
    public void testInsertStudent() {
        Student student = new Student();
        student.setName("test02");
        student.setStatus(0);
        student.setUsername("bettercallsoul");
        student.setPassword("123456");
        student.setMajor("computer science");
        student.setSex(0);
        studentMapper.insertUser(student);
        studentMapper.insertStudent(student);
    }

    @Test
    public void testSelectStudent() {
        studentMapper.updateStatus(104, 1);
        Student stu = studentMapper.selectByStuId(4);
        System.out.println(stu);
    }

    /**
     * test TeacherMapper
     */
    @Autowired
    TeacherMapper teacherMapper;

    @Test
    public void testInsertTeacher() {
        Teacher teacher = new Teacher();
        teacher.setName("teacher su");
        teacher.setPhoneNumber("1881888181");
        teacher.setSex(1);
        teacher.setPassword("123");
        teacher.setStatus(0);
        teacher.setTeacherId(1234);
        teacherMapper.insertUser(teacher);
        teacherMapper.insertTeacher(teacher);

    }

    @Test
    public void testSelectTeacher() {
        Teacher teacher = teacherMapper.selectByTeacherId(1234);
        System.out.println(teacher);
    }

    /**
     * test lesson
     */

    @Autowired
    ClassMapper classMapper;
    @Test
    public void testInsertClass(){
        Class newclass = new Class();
        newclass.setClassId(3);
        newclass.setName("121班");
        newclass.setHeadTeacherId(1234);
        classMapper.insertClass(newclass);
    }
    @Test
    public void testSelectClass(){
        System.out.println(classMapper.selectByClassId(2));
    }
}
