package com.springrestApi.Spring_RestApi.services;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.springrestApi.Spring_RestApi.dao.IStudent;
import com.springrestApi.Spring_RestApi.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ServiceImpl implements StudentService{
    //List<Student> myStudents;
    @Autowired
    private IStudent student;
    public ServiceImpl() {
//        myStudents=new ArrayList<>();
//        myStudents.add(new Student(1,"Saurav Kesari",23));
//        myStudents.add(new Student(2,"Rahul Dave",21));
//        myStudents.add(new Student(3,"Raj Sharma",25));
        System.out.println("Student Constructor");

    }

    @Override
    public List<Student> getAllStudents() {
//        return myStudents;
        return student.findAll();
    }

    @Override
    public Student addStudent(Student s) {
//        if(myStudents.add(s)){
//            return "Student added!!";
//        }
//        return "Student not added!";
      try {
          student.save(s);

      }catch(Exception e){
          System.out.println("Error "+e.getMessage());
      }
      return s;
    }

    @Override
    public Student getStudentById(long id) {
//        Student s=null;
//        for(Student c:myStudents){
//            if(c.getStudId()==id){
//                s=c;
//                break;
//            }
//        }
//        return s;
//        Student s=new Student();
//        try {
//            s= student.getOne(id);
//        }catch (Exception e){
//            System.out.println("Error:="+e.getMessage());
//        }
//        return s;

        Optional<Student> studentOptional = student.findById(id);
        return studentOptional.orElse(null);
    }

    @Override
    public String deleteStudentById(long id) {
//        Student st=null;
//        for(Student s:myStudents){
//            if(s.getStudId()==id){
//                st=s;
//                myStudents.remove(st);
//                return "success";
//            }
//
//        }
//        return "fails";
        try {
            student.deleteById(id);
            return "Success";
        }catch(Exception e){
            return "Failed!";
        }
    }

    @Override
    public Student updateStudent(Student s) {
         student.save(s);
         return s;
    }
}
