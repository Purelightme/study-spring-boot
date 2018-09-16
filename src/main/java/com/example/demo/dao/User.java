package com.example.demo.dao;

import javax.persistence.*;
import javax.validation.constraints.Min;

@Entity
public class User {

    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    private Long id;

    @Column(nullable = false)
    private String name;

    @Min(value = 18,message = "111未成年11ewq2421")
    @Column(nullable = false)
    private Integer age;

    public User(){

    }

    public User(String name,Integer age){
        this.name = name;
        this.age = age;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User [id=" + id + ", name=" + name + ", age=" + age +"]";
    }
}
