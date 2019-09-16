package com.jnshu.mybatisannotation.web;

import com.jnshu.mybatisannotation.dao.UserDAO;
import com.jnshu.mybatisannotation.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**这是jpa方式的查询
 * */
@Controller
public class UserController {

    @Autowired
    UserDAO userDAO;


    @RequestMapping("/user")
    public String listUser(Model m)throws Exception{
        List<User> userList=userDAO.findAll();
        m.addAttribute("userList",userList);
        return "userList";
    }

}
