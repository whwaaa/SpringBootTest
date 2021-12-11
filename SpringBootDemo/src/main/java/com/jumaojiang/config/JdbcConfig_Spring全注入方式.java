package com.jumaojiang.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.sql.DataSource;

/**
 * @Description: Spring全注册实例,jdbc配置类
 * @Auther: whw
 * @Date: 2021/12/10
 * @Week: 星期五
 */
//@Configuration // 声明这是一个属性全注解类
@PropertySource("classpath:jdbc.properties") // 加载属性文件
public class JdbcConfig_Spring全注入方式 {

    @Value(value = "${jdbc.driver}")
    private String driver;
    @Value(value = "${jdbc.url}")
    private String url;
    @Value(value = "${jdbc.username}")
    private String username;
    @Value(value = "${jdbc.password}")
    private String password;

    @Bean // 将方法返回值反转到Spring容器中, 反转的对象名默认为方法名称
    public DruidDataSource dataSource(){
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setUrl(url);
        dataSource.setDriverClassName(driver);
        dataSource.setUsername(username);
        dataSource.setPassword(password);
        return dataSource;
    }

}
