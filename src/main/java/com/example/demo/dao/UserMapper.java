package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);
    User selectByName(String name);
    int insertUser(User user);
    int updateStatus(int id, int status);
    int updatePassword(int id, String password);

}
