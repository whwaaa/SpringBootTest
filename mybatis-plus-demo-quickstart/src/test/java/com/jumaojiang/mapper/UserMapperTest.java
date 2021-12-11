package com.jumaojiang.mapper;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import pojo.User;

import javax.annotation.Resource;

import java.util.List;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/11
 * @Week: 星期六
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class UserMapperTest {

    @Resource
    private UserMapper userMapper;

    @Test
    public void queryTest1(){
        List<User> user = userMapper.selectList(null);
        user.forEach(System.out :: println);
        Assert.assertEquals(25, user.size());
    }

    @Test
    public void insertTest(){
        User user = new User().setUserName("new UserName").setAge(23).setEmail("abc@gmail.com");
        Assert.assertTrue(userMapper.insert(user) > 0);
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void deleteTest(){
        // 通过主键删除
        Assert.assertTrue(userMapper.deleteById(1) > 0);
        userMapper.selectList(null).forEach(System.out :: println);
        // 批量删除
        Assert.assertTrue(userMapper.delete(new QueryWrapper<User>().like("user_name", "J")) > 0);
        userMapper.selectList(null).forEach(System.out :: println);
        // 通过Mappers
        Assert.assertTrue(userMapper.delete(Wrappers.<User>query().like("user_name", "J")) > 0);
        userMapper.selectList(null).forEach(System.out :: println);
        // 通过lambda
        Assert.assertTrue(userMapper.delete(Wrappers.<User>query().lambda().like(User::getUserName,"J")) > 0);
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void updateTest(){
        // 通过主键修改
        Assert.assertTrue(userMapper.updateById(new User().setUserName("hahahah").setId(1l)) > 0);
        userMapper.selectList(null).forEach(System.out::println);
        // 通过QueryWrapper
        Assert.assertTrue(userMapper.update(new User().setEmail("hanwei_wu@163.com"), new QueryWrapper<User>().like("user_name", "J")) > 0);
        userMapper.selectList(null).forEach(System.out::println);
        // 通过Wrappers
        Assert.assertTrue(userMapper.update(new User().setAge(99), Wrappers.<User>query().like("user_name", "J")) > 0);
        userMapper.selectList(null).forEach(System.out::println);
        // 通过lambda
        Assert.assertTrue(userMapper.update(new User().setUserName("abc").setEmail("cba@qq.com"), Wrappers.<User>query().lambda().like(User::getUserName, "J")) > 0);
        userMapper.selectList(null).forEach(System.out::println);
    }

    @Test
    public void queryTest2(){
        // 基本查询
//        System.out.println(userMapper.selectOne(Wrappers.<User>query().lambda().eq(User::getId, 1l)));
        // 投影查询
        userMapper.selectList(Wrappers.<User>query().lambda().select(User::getId,User::getUserName).like(User::getUserName,"啊")).forEach(System.out::println);
    }

}