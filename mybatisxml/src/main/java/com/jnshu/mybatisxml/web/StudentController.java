package com.jnshu.mybatisxml.web;

import com.jnshu.mybatisxml.mapper.StudentMapper;
import com.jnshu.mybatisxml.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {

    Logger logger= LoggerFactory.getLogger(StudentController.class);

    @Autowired
    StudentMapper studentMapper;
    @RequestMapping("/studentList")
    public String findAll(Model model)throws Exception{
        List<Student> studentList=studentMapper.findAllStu();
        model.addAttribute("studentList",studentList);
        return "studentList";
    }


}
