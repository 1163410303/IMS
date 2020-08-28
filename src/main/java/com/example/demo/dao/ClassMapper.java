package com.example.demo.dao;

import com.example.demo.entity.Class;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ClassMapper {
    Class selectByClassId(int classId);

    void insertClass(Class newClass);

}
