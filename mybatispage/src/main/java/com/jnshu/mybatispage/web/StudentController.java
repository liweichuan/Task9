package com.jnshu.mybatispage.web;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jnshu.mybatispage.mapper.StudentMapper;
import com.jnshu.mybatispage.pojo.Student;
import com.jnshu.mybatispage.pojo.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class StudentController {

    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentMapper studentMapper;

    @GetMapping(value = "/students")

    public String listStudent(Model model, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        PageHelper.startPage(start,size,"id desc");
        List<Student> studentList=studentMapper.findAll();
        PageInfo<Student> page = new PageInfo<>(studentList);
        model.addAttribute("page", page);
        return "studentList";
    }

    @PostMapping(value = "/students")
    public String addStudent(Student student) throws Exception {
        studentMapper.insert(student);
        return "redirect:/students";
    }
    @DeleteMapping(value = "/students/{id}")
    public String deleteStudent(Student student) throws Exception {
        studentMapper.delete(student.getId());
        return "redirect:/students";
    }
    @PutMapping(value = "/students/{id}")
    public String updateStudent(Student student) throws Exception {
        studentMapper.update(student);
        return "redirect:/students";
    }
    @GetMapping(value = "/students/{id}")
    public String editStudent(@PathVariable("id") int id,Model m) throws Exception {
        logger.info("传入id"+id);
        Student student=studentMapper.findStudentById(id);
        m.addAttribute("student", student);
        return "editStudent";
    }

}
