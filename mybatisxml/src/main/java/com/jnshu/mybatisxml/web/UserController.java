package com.jnshu.mybatisxml.web;

import com.jnshu.mybatisxml.mapper.StudentMapper;
import com.jnshu.mybatisxml.mapper.UserMapper;
import com.jnshu.mybatisxml.pojo.Student;
import com.jnshu.mybatisxml.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    Logger logger= LoggerFactory.getLogger(StudentController.class);

    @Autowired
    UserMapper userMapper;
    @RequestMapping("/userList")
    public String findAll(Model model)throws Exception{
        List<User> userList=userMapper.findAllUser();
        model.addAttribute("userList",userList);
        return "userList";
    }
}
