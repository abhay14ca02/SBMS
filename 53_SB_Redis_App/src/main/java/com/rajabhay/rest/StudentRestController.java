package com.rajabhay.rest;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.rajabhay.entity.Student;
import com.rajabhay.repo.StudentRepository;

@RestController
public class StudentRestController {

	@Autowired
	private StudentRepository studentRepo;

	@PostMapping("/student")
	public String saveStudent(@RequestBody Student student) {
		studentRepo.save(student);
		return "Student saved..";
	}

	@GetMapping("/students")
	public Iterable<Student> getAllStudents() {
		Iterable<Student> all = studentRepo.findAll();
		return all;
	}

	@Cacheable(value = "students", key = "#sid")
	@GetMapping("/student/{sid}")
	public Student getStudent(@PathVariable Integer sid) {
		return studentRepo.findById(sid).get();
	}
}
