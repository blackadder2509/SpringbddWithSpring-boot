package com.wildcodeschool.exercice.exercicedemo.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wildcodeschool.exercice.exercicedemo.entities.Student;
import com.wildcodeschool.exercice.exercicedemo.repository.StudentRepository;

@RestController
public class StudentController {
	@Autowired
	StudentRepository studentRepo;
	
	@RequestMapping("/create")
	public Student createStudent(String name, String email, String category) {
		Student student = new Student(name, email, category);
		return studentRepo.save(student);
	}
	@RequestMapping("/read")
	public Student getStudent(Long studentId) {
		return studentRepo.findById(studentId).get();
	}
	@RequestMapping("/readall")
	public List<Student>getAllStudent(){
		return studentRepo.findAll();
	}
	@RequestMapping("/update")
	public Student updateStudent(Long studentId, String name, String email, String category) {
		Student studentToUpdate=studentRepo.findById(studentId).get();
		if(name !=null) {
			studentToUpdate.setName(name);
		}
		if(email!=null) {
			studentToUpdate.setEmail(email);
		}
		if(category!=null) {
			studentToUpdate.setCategory(category);
		}
		return studentRepo.save(studentToUpdate);
	}
	@RequestMapping("/delete")
	public void deleteStudent(Long studentId) {
		studentRepo.deleteById(studentId);
	}
	
	
}
