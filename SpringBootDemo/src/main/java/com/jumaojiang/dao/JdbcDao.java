package com.jumaojiang.dao;

import com.jumaojiang.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/10
 * @Week: 星期五
 */
@Component
public class JdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<TbUser> queryAll(){
        return jdbcTemplate.query("select * from tb_user", new BeanPropertyRowMapper<>(TbUser.class));
    }
}
