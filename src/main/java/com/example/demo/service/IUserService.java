package com.example.demo.service;

import java.util.Map;
import com.example.demo.entity.User;


public interface IUserService {

    /**
     * 根据本地ticket获取用户登录状态
     * @param ticket
     * @return  user
     */
    User selectUserByTicket(String ticket);

    /**
     * 注册
     * @param user
     * @return
     */
    Map<String,Object> register(User user);

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
