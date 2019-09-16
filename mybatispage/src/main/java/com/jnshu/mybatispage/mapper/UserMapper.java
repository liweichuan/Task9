package com.jnshu.mybatispage.mapper;

import com.jnshu.mybatispage.pojo.Student;
import com.jnshu.mybatispage.pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface UserMapper {
    //查询所有
    @Select("select * from user")
    List<User> findAll();
    //增加
    @Insert("insert into user(username,password,phone) values(#{username},#{password},#{phone})")
    void insert(User user);
    //删除
    @Delete("delete from user where id=#{id}")
    void delete(int id);
    //查询单个
    @Select("select * from user where id=#{id}")
    User findUserById(int id);
    //更新
    @Update("update user set username=#{username},password=#{password},phone=#{phone} where id=#{id}")
    void  update(User user);
}
