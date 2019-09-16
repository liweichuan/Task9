package com.jnshu.jpa.service.impl;

import com.jnshu.jpa.dao.StudentDao;
import com.jnshu.jpa.pojo.Student;
import com.jnshu.jpa.service.StudentService;
import com.jnshu.jpa.util.Page4Navigator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames="student")
public class StudentServiceImpl implements StudentService {

    @Autowired
    StudentDao studentDao;

//#p0是指在加有@Cacheable注解的方法中的第一个参数，比如上述list(Pageable pageable)中第一个参数就是pageable。#p0.offset相当于pageable.offset的意思
    @Override
    @Cacheable(key = "'student '+#p0.offset+'-'+#p0.pageSize")
    public Page4Navigator<Student> list(Pageable pageable) {
        Page<Student> pageFromJPA=  studentDao.findAll(pageable);
        Page4Navigator<Student> page = new Page4Navigator<>(pageFromJPA,5);
        return page;
    }

    @Override
    @Cacheable(key = "'student '+#p0")
    public Student get(int id) {
        Student student=studentDao.getOne(id);
        return student;
    }

    @Override
    @CacheEvict(allEntries = true)
    //@CachePut(key="'student '+#p0")
    public void save(Student student) {
        studentDao.save(student);
    }

    @Override
    @CacheEvict(allEntries = true)
    //@CacheEvict(key="'student '+#p0")
    public void delete(int id) {
        studentDao.deleteById(id);
    }
}
