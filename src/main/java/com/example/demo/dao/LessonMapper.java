package com.example.demo.dao;

import com.example.demo.entity.Lesson;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface LessonMapper {
    void insertLesson(Lesson lesson);
    Lesson selectById(@Param("lessonId") int lessonId);
    Lesson selectByTeacherId(@Param("teacherId") int teacherId);
    Lesson selectByName(@Param("name") String lessonName);
}
