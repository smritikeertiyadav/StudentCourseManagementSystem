package com.student.service;

import java.util.List;
import com.student.entity.Student;

public interface StudentService {
    Student add(Long userId, Student obj);
    List<Student> getAll();
    List<Student> getByUser(Long userId);
    Student getById(Long id);
    Student update(Long id, Student obj);
    void delete(Long id);
}
