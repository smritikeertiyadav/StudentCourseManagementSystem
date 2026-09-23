package com.student.service;

import java.util.List;
import com.student.entity.Course;

public interface CourseService {
    Course add(Course obj);
    List<Course> getAll();
    Course getById(Long id);
    Course update(Long id, Course obj);
    void delete(Long id);
}
