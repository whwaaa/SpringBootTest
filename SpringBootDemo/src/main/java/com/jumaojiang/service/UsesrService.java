package com.jumaojiang.service;

import com.jumaojiang.dao.TkUserMapper;
import com.jumaojiang.pojo.TbUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/11
 * @Week: 星期六
 */
@Service
public class UsesrService {
    @Resource
    private TkUserMapper tkUserMapper;
    @Transactional(propagation = Propagation.REQUIRED, readOnly = true)
    public List<TbUser> queryAll(){
        return tkUserMapper.selectAll();
    }
}
