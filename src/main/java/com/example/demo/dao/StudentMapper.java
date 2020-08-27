package com.example.demo.dao;

import com.example.demo.entity.Student;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface StudentMapper extends UserMapper{

    Student selectByStuId(int studentId);

    int insertUser(Student student);
}
