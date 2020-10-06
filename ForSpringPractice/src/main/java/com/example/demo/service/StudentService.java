package com.example.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;

@Service
public class StudentService {
	@Autowired
    StudentRepository studentRepository;
	
	
	public List<Student> getStudent() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}
	public Student addStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}
	
	public Student findById(int id) {
		return studentRepository.findById(id).orElse(null);
	}
	
	public void deleteStudent(int id) {
		studentRepository.deleteById(id);
	}
	
	public List<Student> searchStudent(String studentName, String studentEmail) {
		//TODO Auto-generated method stub
		 return studentRepository.searchEntity(studentName,studentEmail);
	}
}