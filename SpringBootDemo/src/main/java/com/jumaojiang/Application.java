package com.jumaojiang;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/10
 * @Week: 星期五
 */
@SpringBootApplication
@MapperScan("com.jumaojiang.dao")
public class Application {
    public static void main(String[] args) {
         SpringApplication.run(Application.class, args);
    }
}
