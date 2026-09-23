package com.student.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.student.entity.Enrollment;
import com.student.entity.Student;
import com.student.entity.Course;

@Repository
public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    List<Enrollment> findByStudent(Student student);
    List<Enrollment> findByCourse(Course course);
    boolean existsByStudentAndCourse(Student student, Course course);
}
