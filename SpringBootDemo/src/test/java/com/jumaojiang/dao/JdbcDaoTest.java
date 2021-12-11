package com.jumaojiang.dao;

import com.jumaojiang.pojo.TbUser;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.util.List;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/10
 * @Week: 星期五
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class JdbcDaoTest {

    @Resource
    private JdbcDao jdbcDao;
    @Resource
    private JdbcMapper jdbcMapper;
    @Resource
    private TkUserMapper tkUserMapper;

    @Test
    public void test001(){
        jdbcDao.queryAll().forEach(user -> {
            System.out.println(user.toString());
        });

        jdbcMapper.queryAll().forEach(user -> {
            System.out.println(user.toString());
        });
    }

    @Test
    public void tkMyBatisTest(){
        tkUserMapper.selectAll().forEach(tbUser -> {
            System.out.println(tbUser.toString());
        });
        System.out.println();

        // 查询名称带有字母A，年龄小于20
        Example example = new Example(TbUser.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andLike("userName", "%A%");
        criteria.andLessThanOrEqualTo("age", 20);
        List<TbUser> tbUsers = tkUserMapper.selectByExample(example);
        tbUsers.forEach(user -> {
            System.out.println(user.toString());
        });
        System.out.println();

        // 自定义sql查询所有
        List<TbUser> tbUsers1 = tkUserMapper.queryAll();
        tbUsers1.forEach(user -> {
            System.out.println(user.toString());
        });
        System.out.println();

        // 自定义sql条件查询
        TbUser tbUser = new TbUser();
        tbUser.setAge(19);
        tbUser.setUserName("A");
        List<TbUser> byUser = tkUserMapper.findByUser(tbUser);
        byUser.forEach(user -> {
            System.out.println(user.toString());
        });
    }
}
