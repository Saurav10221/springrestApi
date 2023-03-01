package com.springrestApi.Spring_RestApi.services;

import com.springrestApi.Spring_RestApi.entity.Student;

import java.util.List;

public interface StudentService {

    public List<Student> getAllStudents();

    //public String getAllStudents();
    public Student addStudent(Student s);

    public Student getStudentById(long id);

    public String deleteStudentById(long id);

    public Student updateStudent(Student s);
}
