package com.jumaojiang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/10
 * @Week: 星期五
 */
//@Configuration
@EnableConfigurationProperties(JdbcProperties.class)
public class JdbcConfig_SpringBoot注入 {

    @Bean
    public DruidDataSource dataSource(JdbcProperties jdbc){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbc.getDriverClassName());
        dataSource.setUrl(jdbc.getUrl());
        dataSource.setPassword(jdbc.getPassword());
        dataSource.setUsername(jdbc.getUsername());
        return dataSource;
    }
}
