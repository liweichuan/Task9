package com.jnshu.jpa;

import com.jnshu.jpa.dao.StudentDao;
import com.jnshu.jpa.dao.UserDao;
import com.jnshu.jpa.pojo.Student;
import com.jnshu.jpa.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = JpaApplication.class)
public class JpaApplicationTests {

    Logger logger= LoggerFactory.getLogger(JpaApplicationTests.class);

    @Autowired
    StudentDao studentDao;

    @Autowired
    UserDao userDao;

    @Test
    public void findAllStudent()throws Exception {
        List<Student> studentList=studentDao.findAll();
        logger.info("查询所有学生。。。。。。。。。。");
        for (Student student:studentList){
            logger.info(String.valueOf(student));
        }
        logger.info("查询所有学生结束。。。。。。。。。。");
    }
    //根据姓名准确查询
    @Test
    public void findStudentByName()throws Exception{
        List<Student> studentList=studentDao.findStudentsByName("李伟川");
        logger.info("根据姓名查询开始。。。。。。。。。。。。");
        for (Student student:studentList){
            logger.info(String.valueOf(student));
        }
        logger.info("根据姓名查询结束。。。。。。。。。。。。。");
    }
    //根据姓名一部分加上id模糊查询
    @Test
    public void findStudentByNameAndId()throws Exception{
        logger.info("根据名称模糊查询，id大于5，并且名称正排序查询");
        List<Student> studentList=studentDao.findStudentsByNameLikeAndIdGreaterThanOrderByNameAsc("%明%",2);
        logger.info("模糊查询开始。。。。。。。。。。。。。。");
        for (Student student:studentList){
            logger.info(String.valueOf(student));
        }
        logger.info("模糊查询结束。。。。。。。。。。。。。。");
    }

//    @Test
//    public void  findAllUser()throws Exception{
//        List<User> userList=userDao.findAll();
//        for (User user:userList){
//            logger.info(String.valueOf(user));
//        }
//    }

}
