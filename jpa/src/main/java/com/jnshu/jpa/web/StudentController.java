package com.jnshu.jpa.web;

import com.jnshu.jpa.dao.StudentDao;
import com.jnshu.jpa.pojo.Student;
import com.jnshu.jpa.service.StudentService;
import com.jnshu.jpa.util.Page4Navigator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class StudentController {

    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentService studentService;

    @GetMapping(value = "/students")
    public String listStudent(Model model, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        start=start<0?0:start;//三目表达式，start小于0取0，大于等于0取start
        //查询的排序选项。
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page4Navigator<Student> page =studentService.list(pageable);
        model.addAttribute("page", page);
        return "studentList";
    }

    @PostMapping(value = "/students")
    public String addStudent(Student student) throws Exception {
        studentService.save(student);
        return "redirect:/students";
    }
    @DeleteMapping(value = "/students/{id}")
    public String deleteStudent(Student student) throws Exception {
        studentService.delete(student.getId());
        return "redirect:/students";
    }
    @PutMapping(value = "/students/{id}")
    public String updateStudent(Student student) throws Exception {
        studentService.save(student);
        return "redirect:/students";
    }
    @GetMapping(value = "/students/{id}")
    public String editStudent(@PathVariable("id") int id,Model m) throws Exception {
        logger.info("传入id"+id);
        Student student= studentService.get(id);
        m.addAttribute("student", student);
        return "editStudent";
    }

}
