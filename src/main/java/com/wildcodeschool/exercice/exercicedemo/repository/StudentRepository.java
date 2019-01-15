package com.wildcodeschool.exercice.exercicedemo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wildcodeschool.exercice.exercicedemo.entities.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
