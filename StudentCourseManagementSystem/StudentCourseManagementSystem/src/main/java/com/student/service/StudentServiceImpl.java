package com.student.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.entity.Student;
import com.student.entity.User;
import com.student.exception.ResourceNotFoundException;
import com.student.repository.StudentRepository;
import com.student.repository.UserRepository;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired private StudentRepository repository;
    @Autowired private UserRepository userRepository;

    @Override
    public Student add(Long userId, Student obj) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        obj.setUser(user);
        return repository.save(obj);
    }

    @Override public List<Student> getAll() { return repository.findAll(); }

    @Override
    public List<Student> getByUser(Long userId) {
        User user = userRepository.findById(userId)
            .orElseThrow(() -> new ResourceNotFoundException("User not found with id " + userId));
        return repository.findByUser(user);
    }

    @Override
    public Student getById(Long id) {
        return repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + id));
    }

    @Override
    public Student update(Long id, Student obj) {
        Student existing = getById(id);
        existing.setName(obj.getName());
        existing.setAge(obj.getAge());
        existing.setEmail(obj.getEmail());
        existing.setDepartment(obj.getDepartment());
        existing.setSemester(obj.getSemester());
        return repository.save(existing);
    }

    @Override public void delete(Long id) { repository.delete(getById(id)); }
}
