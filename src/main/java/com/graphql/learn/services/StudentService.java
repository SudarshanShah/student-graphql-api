package com.graphql.learn.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.graphql.learn.exception.StudentNotFoundException;
import com.graphql.learn.model.Student;
import com.graphql.learn.repo.StudentRepo;

@Service
public class StudentService {

	@Autowired
	private StudentRepo studentRepo;
	
	public Student addStudent(Student student) {
		return this.studentRepo.save(student);
	}
	
	public Student updateStudent(Student student, int sid) {
		Student s = this.studentRepo.findById(sid)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id : " + sid));
		
		s.setName(student.getName());
		s.setDept(student.getDept());
		s.setFavSport(student.getFavSport());
		s.setClassTeacher(student.getClassTeacher());
		
		return this.studentRepo.save(s);
	}
	
	public void delete(int sid) {
		Student s = this.studentRepo.findById(sid)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id : " + sid));
		
		this.studentRepo.delete(s);
	}
	
	public List<Student> getAllStudents() {
		return this.studentRepo.findAll();
	}
	
	public Student getStudentById(int sid) {
		Student s = this.studentRepo.findById(sid)
				.orElseThrow(() -> new StudentNotFoundException("Student not found with id : " + sid));
		
		return s;
	}
}
