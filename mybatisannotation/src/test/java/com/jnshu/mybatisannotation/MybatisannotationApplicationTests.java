package com.jnshu.mybatisannotation;

import com.jnshu.mybatisannotation.mapper.StudentMapper;
import com.jnshu.mybatisannotation.pojo.Student;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest(classes = {MybatisannotationApplication.class})
public class MybatisannotationApplicationTests {

    Logger logger= LoggerFactory.getLogger(MybatisannotationApplicationTests.class);

    @Autowired
    StudentMapper studentMapper;

    @Test
    public void findAll()throws Exception{
        List<Student> studentList=studentMapper.findAll();
        logger.info(String.valueOf(studentList));
    }
    @Test
    public void  finaById() throws Exception{
        Student student=studentMapper.findStudentById(1);
        logger.info(String.valueOf(student));
    }
    @Test
    public void add()throws Exception{
        Student student=new Student();
        student.setName("学生1");
        student.setType("java工程师");
        student.setWish("希望可以通过学习找到一份好工作");
        studentMapper.insert(student);
    }
    @Test
    public void delete()throws Exception{
        studentMapper.delete(2);
    }
    @Test
    public void update()throws Exception{
        Student student=new Student();
        student.setId(1);
        student.setName("普通人");
        student.setType("web前端工程师");
        student.setWish("学成出去找到好工作");
        studentMapper.update(student);
    }

}
