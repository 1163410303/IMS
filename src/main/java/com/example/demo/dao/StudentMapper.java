package com.example.demo.dao;

import com.example.demo.entity.Student;
import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface StudentMapper extends UserMapper{

    Student selectByStuId(@Param("stuId") int studentId);

    int insertStudent(Student student);

}
