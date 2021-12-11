package com.jumaojiang.dao;

import com.jumaojiang.pojo.TbUser;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/11
 * @Week: 星期六
 */
public interface TkUserMapper extends Mapper<TbUser> {

    public List<TbUser> queryAll();

    public List<TbUser> findByUser(TbUser tbUser);
}
