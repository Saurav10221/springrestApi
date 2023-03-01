package com.springrestApi.Spring_RestApi.dao;

import com.springrestApi.Spring_RestApi.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IStudent extends JpaRepository<Student,Long> {
    Optional<Student> findById(Long id);
}
