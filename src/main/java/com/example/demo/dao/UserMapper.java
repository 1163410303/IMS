package com.example.demo.dao;

import com.example.demo.entity.User;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    User selectById(int id);

    User selectByName(String name);

    int insertUser(User user);

    /**
     * 设置用户状态，0代表注册用户，1代表已停用
     *
     * @param id
     * @param status
     * @return
     */
    int updateStatus(int id, int status);

    int updatePassword(int id, String password);


}
