package com.test.springdemo.rest;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.test.springdemo.entity.Student;

@RestController
@RequestMapping("/api")
public class StudentRestController {
	
	private List<Student> theStudentList;
	
	@PostConstruct
	public void loadData() {
		theStudentList = new ArrayList<Student>();
		
		theStudentList.add(new Student("Chetan", "L"));
		theStudentList.add(new Student("Mohan", "P"));
		theStudentList.add(new Student("Meghnath", "R"));
		theStudentList.add(new Student("Naveen", "K"));
		theStudentList.add(new Student("Samuel", "P C"));
	}
	
	@GetMapping("/students")
	public List<Student> getStudents() {
		
		return theStudentList;
		
	}
	
	@GetMapping("/students/{studentId}")
	public Student getStudent(@PathVariable int studentId){
		
		if(studentId >= theStudentList.size() || studentId < 0) {
			throw new StudentNotFoundException("Student Id not found - "+ studentId);
		}
		
		return theStudentList.get(studentId);
	}
	
}
