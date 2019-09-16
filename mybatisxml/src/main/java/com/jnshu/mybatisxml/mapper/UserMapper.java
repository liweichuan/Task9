package com.jnshu.mybatisxml.mapper;

import com.jnshu.mybatisxml.pojo.User;


import java.util.List;

public interface UserMapper {
    //增加
    public void addUser(User user);
    //删除
    public void deleteUserById(int id);
    //查询
    public User findUserById(int id);
    //查询所有
    List<User> findAllUser();
    //更新
    public void updateUserById(int id);
}
