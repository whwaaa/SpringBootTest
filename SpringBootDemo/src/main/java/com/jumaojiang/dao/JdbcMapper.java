package com.jumaojiang.dao;

import com.jumaojiang.pojo.TbUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/10
 * @Week: 星期五
 */
//@Mapper
public interface JdbcMapper {
    public List<TbUser> queryAll();
}
