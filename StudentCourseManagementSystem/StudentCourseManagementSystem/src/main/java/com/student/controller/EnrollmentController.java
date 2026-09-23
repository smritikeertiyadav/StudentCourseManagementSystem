package com.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.student.entity.Enrollment;
import com.student.service.EnrollmentService;

@RestController
@RequestMapping("/api/enrollments")
public class EnrollmentController {
    @Autowired private EnrollmentService service;

    @PostMapping("/student/{studentId}/course/{courseId}")
    public ResponseEntity<Enrollment> enroll(@PathVariable Long studentId, @PathVariable Long courseId) {
        return new ResponseEntity<>(service.enroll(studentId, courseId), HttpStatus.CREATED);
    }

    @GetMapping public ResponseEntity<List<Enrollment>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/student/{studentId}")
    public ResponseEntity<List<Enrollment>> getByStudent(@PathVariable Long studentId) {
        return ResponseEntity.ok(service.getByStudent(studentId));
    }

    @GetMapping("/course/{courseId}")
    public ResponseEntity<List<Enrollment>> getByCourse(@PathVariable Long courseId) {
        return ResponseEntity.ok(service.getByCourse(courseId));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> drop(@PathVariable Long id) {
        service.drop(id);
        return ResponseEntity.ok("Enrollment deleted successfully");
    }
}
