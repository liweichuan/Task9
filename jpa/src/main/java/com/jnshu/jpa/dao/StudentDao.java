package com.jnshu.jpa.dao;

import com.jnshu.jpa.pojo.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface StudentDao extends JpaRepository<Student,Integer> {
    public List<Student> findStudentsByName(String name);

    public List<Student> findStudentsByNameLikeAndIdGreaterThanOrderByNameAsc(String name,int id);

}
