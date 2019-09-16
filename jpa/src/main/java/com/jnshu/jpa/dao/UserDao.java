package com.jnshu.jpa.dao;

import com.jnshu.jpa.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDao extends JpaRepository<User,Integer> {
}
