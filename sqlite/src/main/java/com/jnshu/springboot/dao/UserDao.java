package com.jnshu.springboot.dao;


import com.jnshu.springboot.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
