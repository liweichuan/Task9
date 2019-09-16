package com.jnshu.json.web;

import com.jnshu.json.dao.StudentDao;
import com.jnshu.json.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentDao studentDao;

    //getMany.html调用的接口
    @GetMapping(value = "/students")
    public List<Student> listStudent(Model model, @RequestParam(value = "start",defaultValue = "0") int start, @RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        start=start<0?0:start;//三目表达式，start小于0取0，大于等于0取start
        //查询的排序选项。
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Student> page =studentDao.findAll(pageable);
        model.addAttribute("page", page);
        return page.getContent();
    }
    //getOne.html绑定的接口
    @GetMapping(value = "/students/{id}")
    public Student getStudent(@PathVariable("id") int id) throws Exception {
        logger.info("传入id"+id);
        Student student= studentDao.getOne(id);
        logger.info(String.valueOf(student));
        return student;
    }
    //submit.html绑定的接口
    @PutMapping(value = "/students")
    public void addStudent(@RequestBody Student student) throws Exception {
        logger.info("springboot接受到浏览器以JSON格式提交的数据："+student);
    }

}
