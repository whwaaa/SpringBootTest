package com.jumaojiang.controller;

import com.jumaojiang.pojo.TbUser;
import com.jumaojiang.service.UsesrService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Auther: whw
 * @Date: 2021/12/11
 * @Week: 星期六
 */
@Controller
public class UserController {

    @Autowired
    private UsesrService usesrService;

    @RequestMapping("/all")
    public String user(Model model){
        List<TbUser> tbUsers = usesrService.queryAll();
        model.addAttribute("users", tbUsers);
        // 返回模板名称 (classpath:templates/模板名称.html)
        return "users";
    }
}
