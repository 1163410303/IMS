package com.example.demo.dao;

import com.example.demo.entity.Lesson;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class LessonMapperTest {

    @Autowired
    LessonMapper lessonMapper;

    @Test
    void insertLesson() {
        Lesson lesson = new Lesson(112, "生物", 1234, "3.0");
        lessonMapper.insertLesson(lesson);
    }

    @Test
    void selectById() {
        Lesson lesson = lessonMapper.selectById(12);
        System.out.println(lesson);
    }

    @Test
    void selectByTeacherId() {
        Lesson lesson = lessonMapper.selectByTeacherId(1);
        System.out.println(lesson);
    }

    @Test
    void selectByName() {
        Lesson lesson = lessonMapper.selectByName("生物");
        System.out.println(lesson);
    }
}