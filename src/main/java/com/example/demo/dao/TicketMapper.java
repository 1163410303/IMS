package com.example.demo.dao;

import com.example.demo.entity.LoginTicket;
import org.apache.ibatis.annotations.*;

@Mapper
public interface TicketMapper {

    @Insert({
            "insert into login_ticket(user_id,ticket,status) ",
            "values(#{userId},#{ticket},#{status})"
    })
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insertLoginTicket(LoginTicket loginTicket);

    @Select({
            "select id,user_id,ticket,status ",
            "from login_ticket where ticket=#{ticket}"
    })
    LoginTicket selectByTicket(String ticket);

    @Update({
            "update login_ticket set status=#{status} where ticket=#{ticket} "
    })
    int updateStatus(String ticket, int status);

}
