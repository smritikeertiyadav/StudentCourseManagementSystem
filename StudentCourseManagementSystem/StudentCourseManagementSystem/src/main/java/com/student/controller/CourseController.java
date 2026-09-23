package com.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.student.entity.Course;
import com.student.service.CourseService;

@RestController
@RequestMapping("/api/courses")
public class CourseController {
    @Autowired private CourseService service;

    @PostMapping
    public ResponseEntity<Course> add(@RequestBody Course obj) {
        return new ResponseEntity<>(service.add(obj), HttpStatus.CREATED);
    }

    @GetMapping public ResponseEntity<List<Course>> getAll() { return ResponseEntity.ok(service.getAll()); }

    @GetMapping("/{id}")
    public ResponseEntity<Course> getById(@PathVariable Long id) { return ResponseEntity.ok(service.getById(id)); }

    @PutMapping("/{id}")
    public ResponseEntity<Course> update(@PathVariable Long id, @RequestBody Course obj) {
        return ResponseEntity.ok(service.update(id, obj));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.ok("Course deleted successfully");
    }
}
