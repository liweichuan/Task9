package com.jnshu.mybatisannotation.web;

import com.jnshu.mybatisannotation.mapper.StudentMapper;
import com.jnshu.mybatisannotation.pojo.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class StudentController {
    @Autowired
    StudentMapper studentMapper;

    @RequestMapping("/studentList")
    public String findAll(Model m)throws Exception{
        List<Student> studentList=studentMapper.findAll();
        m.addAttribute("studentList",studentList);
        return "studentList";
    }
}
