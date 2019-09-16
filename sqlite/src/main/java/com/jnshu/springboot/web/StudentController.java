package com.jnshu.springboot.web;


import com.jnshu.springboot.dao.StudentDao;
import com.jnshu.springboot.pojo.Student;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class StudentController {

    Logger logger= LoggerFactory.getLogger(StudentController.class);
    @Autowired
    StudentDao studentDao;

    @RequestMapping(value = "/studentList")

    public String listStudent(Model model, @RequestParam(value = "start",defaultValue = "0") int start,@RequestParam(value = "size",defaultValue = "5") int size) throws Exception{
        start=start<0?0:start;//三目表达式，start小于0取0，大于等于0取start
        //查询的排序选项。
        Sort sort = new Sort(Sort.Direction.DESC, "id");
        Pageable pageable = new PageRequest(start, size, sort);
        Page<Student> page =studentDao.findAll(pageable);

//
//        System.out.println(page.getNumber());
//        System.out.println(page.getNumberOfElements());
//        System.out.println(page.getSize());
//        System.out.println(page.getTotalElements());
//        System.out.println(page.getTotalPages());

        model.addAttribute("page", page);

        return "studentList";
    }

    @RequestMapping(value = "/addStudent")
    public String addStudent(Student student) throws Exception {
        studentDao.save(student);
        return "redirect:studentList";
    }
    @RequestMapping(value = "/deleteStudent")
    public String deleteStudent(Student student) throws Exception {
        studentDao.delete(student);
        return "redirect:studentList";
    }
    @RequestMapping(value = "/updateStudent")
    public String updateStudent(Student student) throws Exception {
        studentDao.save(student);
        return "redirect:studentList";
    }
    @RequestMapping(value = "/editStudent")
    public String editStudent(int id,Model m) throws Exception {
        logger.info("传入id"+id);
        Student student= studentDao.getOne(id);
        m.addAttribute("student", student);
        return "editStudent";
    }

}
