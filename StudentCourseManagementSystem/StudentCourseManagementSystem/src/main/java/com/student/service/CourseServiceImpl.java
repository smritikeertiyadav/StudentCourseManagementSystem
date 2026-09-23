package com.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.entity.Course;
import com.student.exception.ResourceNotFoundException;
import com.student.repository.CourseRepository;

@Service
public class CourseServiceImpl implements CourseService {
    @Autowired private CourseRepository repository;

    @Override
    public Course add(Course obj) {
        if (repository.findByCourseCode(obj.getCourseCode()) != null)
            throw new RuntimeException("Course code already exists");
        return repository.save(obj);
    }

    @Override public List<Course> getAll() { return repository.findAll(); }

    @Override
    public Course getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + id));
    }

    @Override
    public Course update(Long id, Course obj) {
        Course existing = getById(id);
        existing.setCourseName(obj.getCourseName());
        existing.setCourseCode(obj.getCourseCode());
        existing.setCredits(obj.getCredits());
        existing.setInstructor(obj.getInstructor());
        return repository.save(existing);
    }

    @Override public void delete(Long id) { repository.delete(getById(id)); }
}
