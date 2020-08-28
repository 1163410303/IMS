package com.example.demo.dao;

import com.example.demo.entity.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface TeacherMapper extends UserMapper{

    Teacher selectByTeacherId(@Param("teacherId") int teacherId);

    int insertTeacher(Teacher teacher);

}
