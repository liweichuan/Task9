package com.jnshu.mybatisxml.mapper;

import com.jnshu.mybatisxml.pojo.Student;


import java.util.List;


public interface StudentMapper {
    //增加
    public void addStu(Student student);
    //删除
    public void deleteStudentById(int id);
    //查询
    public Student findStudentById(int id);
    //查询所有
    List<Student> findAllStu();
    //更新
    public void updateStudentById(int id);
}
