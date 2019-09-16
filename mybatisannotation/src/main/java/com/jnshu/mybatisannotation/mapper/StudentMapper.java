package com.jnshu.mybatisannotation.mapper;

import com.jnshu.mybatisannotation.pojo.Student;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.util.List;

@Mapper
@Component
public interface StudentMapper {
    //查询所有
    @Select("select * from student")
    List<Student> findAll();
    //增加
    @Insert("insert into student(name,type,wish) values(#{name},#{type},#{wish})")
    void insert(Student student);
    //删除
    @Delete("delete from student where id=#{id}")
    void delete(int id);
    //查询单个
    @Select("select * from student where id=#{id}")
    Student findStudentById(int id);
    //更新
    @Update("update student set name=#{name},type=#{type},wish=#{wish} where id=#{id}")
    void  update(Student student);

}
