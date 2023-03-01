package com.springrestApi.Spring_RestApi.entity;

import jakarta.persistence.*;

@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="stud_id")
    private long studId;
    private String name;
    private int age;

    public Student(){}
    public Student(long studId, String name, int age) {
        this.studId = studId;
        this.name = name;
        this.age = age;
    }

    public long getStudId() {
        return studId;
    }

    public void setStudId(long studId) {
        this.studId = studId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
