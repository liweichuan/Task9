package com.jnshu.mybatisannotation.dao;

import com.jnshu.mybatisannotation.pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**这是jpa方式
 * */
public interface UserDAO extends JpaRepository<User,Integer> {
}
