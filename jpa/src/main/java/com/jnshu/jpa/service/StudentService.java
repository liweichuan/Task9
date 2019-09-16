package com.jnshu.jpa.service;

import com.jnshu.jpa.pojo.Student;
import com.jnshu.jpa.util.Page4Navigator;
import org.springframework.data.domain.Pageable;

public interface StudentService {
    public Page4Navigator<Student> list(Pageable pageable);
    public void save(Student student);
    public void delete(int id);
    public Student get(int id);
}
