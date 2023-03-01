package com.springrestApi.Spring_RestApi.controllers;

import com.springrestApi.Spring_RestApi.services.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;
import com.springrestApi.Spring_RestApi.entity.Student;

import java.util.List;

@RestController
public class Myctrl {
    @Autowired
    private StudentService service;

    @GetMapping("/home")
    public String home(){
        return "Welcome to Home Page of REST API";
    }

    @GetMapping("/students")
    public List<Student> getAllStudents(){
        return this.service.getAllStudents();
    }

    @PostMapping(path="/students/add",consumes = MediaType.APPLICATION_JSON_VALUE,produces = MediaType.APPLICATION_JSON_VALUE)
    public Student addStudent(@RequestBody Student s){
         this.service.addStudent(s);
         return s;
    }

    @GetMapping("/students/{studId}")
    public Student getStudentById(@PathVariable String studId){
        Student student = this.service.getStudentById(Long.parseLong(studId));
        if(student==null){
            return null;
        }
        return student;
    }


    @PutMapping("/students/update")
    public Student updateStudent(@RequestBody Student s){
        return this.service.updateStudent(s);
    }

    @DeleteMapping("students/{delId}")
    public String deleteStudentById(@PathVariable String delId){
        if(!this.service.deleteStudentById(Long.parseLong(delId)).endsWith("fails")){
            return "Student deleted!";
        }
        return "Student not deleted!";
    }
}
