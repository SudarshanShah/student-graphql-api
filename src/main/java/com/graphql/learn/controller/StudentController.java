package com.graphql.learn.controller;

import com.graphql.learn.model.Student;
import com.graphql.learn.services.StudentService;
import com.graphql.learn.utils.ApiResponse;
import com.graphql.learn.utils.StudentInput;
import lombok.extern.slf4j.Slf4j;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.util.List;

@Controller
@Slf4j
public class StudentController {

	private final StudentService studentService;

	public StudentController(StudentService studentService) {
		this.studentService = studentService;
	}

	@MutationMapping("addStudent")
	public Student addStudent(@Argument StudentInput studentInput) {
		Student student = new Student();
		student.setName(studentInput.getName());
		student.setDept(studentInput.getDept());
		student.setFavSport(studentInput.getFavSport());
		student.setClassTeacher(studentInput.getClassTeacher());
		
		Student createdStudent = this.studentService.addStudent(student);
		log.info("Student created successfully");
		
		return createdStudent;
	}
	
	@MutationMapping("updateStudent")
	public Student updateStudent(@Argument StudentInput studentInput, @Argument Integer sid) {
		Student student = new Student();
		student.setName(studentInput.getName());
		student.setDept(studentInput.getDept());
		student.setFavSport(studentInput.getFavSport());
		student.setClassTeacher(studentInput.getClassTeacher());
		
		Student updatedStudent = this.studentService.updateStudent(student, sid);
		log.info("Student updated successfully");
		
		return updatedStudent;
	}
	
	@QueryMapping("getAllStudents")
	public List<Student> getAllStudents() {
		List<Student> allStudents = this.studentService.getAllStudents();
		log.info("The getAllStudents() query executed successfully");
		return allStudents;
	}
	
	@QueryMapping("getStudent")
	public Student getStudentById(@Argument Integer sid) {
		Student studentById = this.studentService.getStudentById(sid);
		log.info("The getStudent() query executed successfully");
		return studentById;
	}
	
	@MutationMapping("deleteStudent")
	public ApiResponse deleteStudent(@Argument Integer sid) {
		this.studentService.delete(sid);
		log.info("The deleteStudent() query executed successfully");
		return new ApiResponse("Student deleted successfully", true);
	}
}
