package com.jnshu.mybatispage.web;



import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnshu.mybatispage.mapper.UserMapper;
import com.jnshu.mybatispage.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    UserMapper userMapper;

    @GetMapping("/users")
    public String listUser(Model model, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id desc");
        List<User> userList=userMapper.findAll();
        PageInfo<User> page = new PageInfo<>(userList);
        model.addAttribute("page", page);
        return "userList";
    }

    @PostMapping("/users")
    public String addUser(User user) throws Exception {
        userMapper.insert(user);
        return "redirect:/users";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(User user) throws Exception {
        userMapper.delete(user.getId());
        return "redirect:/users";
    }
    @PutMapping("/users/{id}")
    public String updateUser(User user) throws Exception {
        userMapper.update(user);
        return "redirect:/users";
    }
    @RequestMapping("/users/{id}")
    public String editUser(@PathVariable("id") int id,Model m) throws Exception {
        User user= userMapper.findUserById(id);
        m.addAttribute("user", user);
        return "editUser";
    }

}
