package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.GlobalConstant;
import com.example.demo.entity.Student;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
@Autowired
StudentService teacherService;
	@GetMapping (value = "/student")
	public List<Student> getStudent1(){
		return teacherService.getStudent();
	}
	@GetMapping (value = "/student")
	public BaseResponse getStudent() {
		List<Student> students= teacherService.getStudent();
		return new BaseResponse(GlobalConstant.SUCCESS, students,GlobalConstant.Message.SUCCESS_MESSAGE);
	}
	
}
