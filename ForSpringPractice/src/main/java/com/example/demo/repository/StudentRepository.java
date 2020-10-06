package com.example.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.demo.entity.Student;

public interface StudentRepository extends JpaRepository<Student,Integer>{
	@Query(value="Select s from Student s where s.name like concat('%',concat(?1,'%'))"+"and s.email like concat('%',concat(?2,'%'))") 
	List<Student>searchEntity(String studetName,String studentEmail);

}
