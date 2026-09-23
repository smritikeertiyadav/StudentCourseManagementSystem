package com.student.service;

import java.time.LocalDate;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.student.entity.Course;
import com.student.entity.Enrollment;
import com.student.entity.Student;
import com.student.exception.ResourceNotFoundException;
import com.student.repository.CourseRepository;
import com.student.repository.EnrollmentRepository;
import com.student.repository.StudentRepository;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    @Autowired private EnrollmentRepository repository;
    @Autowired private StudentRepository studentRepository;
    @Autowired private CourseRepository courseRepository;

    @Override
    public Enrollment enroll(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        if (repository.existsByStudentAndCourse(student, course))
            throw new RuntimeException("Student is already enrolled in this course");

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);
        enrollment.setEnrollmentDate(LocalDate.now());
        enrollment.setStatus("ACTIVE");
        return repository.save(enrollment);
    }

    @Override public List<Enrollment> getAll() { return repository.findAll(); }

    @Override
    public List<Enrollment> getByStudent(Long studentId) {
        Student student = studentRepository.findById(studentId)
            .orElseThrow(() -> new ResourceNotFoundException("Student not found with id " + studentId));
        return repository.findByStudent(student);
    }

    @Override
    public List<Enrollment> getByCourse(Long courseId) {
        Course course = courseRepository.findById(courseId)
            .orElseThrow(() -> new ResourceNotFoundException("Course not found with id " + courseId));
        return repository.findByCourse(course);
    }

    @Override
    public void drop(Long enrollmentId) {
        Enrollment enrollment = repository.findById(enrollmentId)
            .orElseThrow(() -> new ResourceNotFoundException("Enrollment not found with id " + enrollmentId));
        repository.delete(enrollment);
    }
}
