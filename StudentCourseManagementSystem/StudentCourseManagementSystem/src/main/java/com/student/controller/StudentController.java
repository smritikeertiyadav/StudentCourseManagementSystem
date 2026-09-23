package com.student.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;
import com.student.entity.Student;
import com.student.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired private StudentService service;

	@PostMapping("/user/{userId}")
	public ResponseEntity<Student> add(@PathVariable Long userId, @RequestBody Student obj) {
		return new ResponseEntity<>(service.add(userId, obj), HttpStatus.CREATED);
	}

	@GetMapping public ResponseEntity<List<Student>> getAll() { return ResponseEntity.ok(service.getAll()); }

	@GetMapping("/user/{userId}")
	public ResponseEntity<List<Student>> getByUser(@PathVariable Long userId) {
		return ResponseEntity.ok(service.getByUser(userId));
	}

	@GetMapping("/{id}")
	public ResponseEntity<Student> getById(@PathVariable Long id) { return ResponseEntity.ok(service.getById(id)); }

	@PutMapping("/{id}")
	public ResponseEntity<Student> update(@PathVariable Long id, @RequestBody Student obj) {
		return ResponseEntity.ok(service.update(id, obj));
	}

	@DeleteMapping("/{id}")
	public ResponseEntity<String> delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.ok("Student deleted successfully");
	}
}
