package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.constant.GlobalConstant;
import com.example.demo.entity.Student;
import com.example.demo.pojo.StudentPojo;
import com.example.demo.response.BaseResponse;
import com.example.demo.service.StudentService;

@RestController
public class StudentController {
	
@Autowired
StudentService studentService;
	
	@GetMapping (value = "/student")
	public BaseResponse getStudent() {
		try{
			List<Student> students= studentService.getStudent();
			return new BaseResponse(GlobalConstant.SUCCESS, students,GlobalConstant.Message.SUCCESS_MESSAGE);
		}catch(Exception e) {
			System.out.println("Error occur "+e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null,GlobalConstant.Message.FAIL_MESSAGE);
		}

	}
	
	@PostMapping(value="/student")
	public BaseResponse addStudent(@RequestBody Student student) {
		try{
			Student students=studentService.addStudent(student);
			return new BaseResponse(GlobalConstant.SUCCESS, students,GlobalConstant.Message.SUCCESS_MESSAGE);
		}catch(Exception e) {
			System.out.println("Error occur "+e.getMessage());
			return new BaseResponse(GlobalConstant.FAIL, null,GlobalConstant.Message.FAIL_MESSAGE);
		}
		
	}
	
	@PutMapping(value="/student")
	public BaseResponse updateStudent(@RequestBody StudentPojo studentPojo) {
	  try{
		  Student student = studentService.findById(studentPojo.getId());
	  
	      if(student == null) {
		      return null;
	      }
		
			student.setName(studentPojo.getName());
			student.setEmail(studentPojo.getEmail());
			Student st= studentService.save(student);
			
			return new BaseResponse(GlobalConstant.SUCCESS, st,GlobalConstant.Message.SUCCESS_MESSAGE);
	  }catch(Exception e) {
		  return new BaseResponse(GlobalConstant.FAIL, null,GlobalConstant.Message.FAIL_MESSAGE);
	  }
	}
	
}
