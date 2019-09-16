package com.jnshu.springboot.dao;


import com.jnshu.springboot.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentDao extends JpaRepository<Student,Integer> {
}
