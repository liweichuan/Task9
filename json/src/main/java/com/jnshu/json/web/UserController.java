package com.jnshu.json.web;

import com.jnshu.json.dao.UserDao;
import com.jnshu.json.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {

    @Autowired
    UserDao userDao;

    @GetMapping("/users")
    public String listUser(Model model, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        start=start<0?0:start;//三目表达式，start小于0取0，大于等于0取start
        //查询的排序选项。
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<User> page =userDao.findAll(pageable);
        model.addAttribute("page", page);
        return "userList";
    }

    @PostMapping("/users")
    public String addUser(User user) throws Exception {
        userDao.save(user);
        return "redirect:/users";
    }
    @DeleteMapping("/users/{id}")
    public String deleteUser(User user) throws Exception {
        userDao.delete(user);
        return "redirect:/users";
    }
    @PutMapping("/users/{id}")
    public String updateUser(User user) throws Exception {
        userDao.save(user);
        return "redirect:/users";
    }
    @GetMapping("/users/{id}")
    public String editUser(@PathVariable("id") int id,Model m) throws Exception {
        User user= userDao.getOne(id);
        m.addAttribute("user", user);
        return "editUser";
    }

}
