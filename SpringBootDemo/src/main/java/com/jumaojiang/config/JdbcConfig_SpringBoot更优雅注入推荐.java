package com.jumaojiang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/10
 * @Week: 星期五
 */
//@Configuration
public class JdbcConfig_SpringBoot更优雅注入推荐 {

    @Bean
    @ConfigurationProperties(prefix = "jdbc")
    public DruidDataSource dataSource(){
        return new DruidDataSource();
    }
}
