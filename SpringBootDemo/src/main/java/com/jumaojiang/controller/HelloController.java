package com.jumaojiang.controller;

import com.alibaba.druid.pool.DruidDataSource;
import com.jumaojiang.pojo.TbUser;
import com.jumaojiang.service.UsesrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;
import java.util.List;


/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/10
 * @Week: 星期五
 */
@RestController
public class HelloController {

//    @Autowired
//    private DruidDataSource dataSource;

    @Autowired
    private DataSource dataSource;


    @GetMapping("/hello")
    public String hello(){
//        System.out.println("url: " + dataSource.getUrl());
//        System.out.println("driver: " + dataSource.getDriverClassName());
//        System.out.println("username: " + dataSource.getUsername());
//        System.out.println("password: " + dataSource.getPassword());
        return "hello spring boot.";
    }

}
