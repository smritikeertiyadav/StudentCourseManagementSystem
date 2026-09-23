package com.student.service;

import java.util.List;
import com.student.entity.Enrollment;

public interface EnrollmentService {
    Enrollment enroll(Long studentId, Long courseId);
    List<Enrollment> getAll();
    List<Enrollment> getByStudent(Long studentId);
    List<Enrollment> getByCourse(Long courseId);
    void drop(Long enrollmentId);
}
