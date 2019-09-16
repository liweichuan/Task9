package com.jnshu.mybatispage.mapper;

import com.jnshu.mybatispage.pojo.Student;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

public interface StudentMapper {
    //查询所有
    @Select("select * from student")
    List<Student> findAll();
    //增加
    @Insert("insert into student(name,type,wish) values(#{name},#{type},#{wish})")
    public void insert(Student student);
    //删除
    @Delete("delete from student where id=#{id}")
    public void delete(int id);
    //查询单个
    @Select("select * from student where id=#{id}")
    public Student findStudentById(int id);
    //更新
    @Update("update student set name=#{name},type=#{type},wish=#{wish} where id=#{id}")
    public void update(Student student);

}
