package com.graphql.learn.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.graphql.learn.model.Student;

public interface StudentRepo extends JpaRepository<Student, Integer> {

}
