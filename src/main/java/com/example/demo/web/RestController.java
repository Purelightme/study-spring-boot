package com.example.demo.web;

import com.example.demo.config.HomeProperties;
import com.example.demo.dao.User;
import com.example.demo.dao.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Component
@org.springframework.web.bind.annotation.RestController
@RequestMapping(path = "/user")
public class RestController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private HomeProperties homeProperties;

    @RequestMapping("/create/{name}/{age}")
    public String create(@PathVariable String name,@PathVariable int age){
        User user = new User(name,age);
        userRepository.save(user);
        return  "create successful";
    }

    @RequestMapping("/del/{id}")
    public String del(@PathVariable long id){
        userRepository.deleteById(id);
        return  "delete successful";
    }

    @RequestMapping("/update/{id}/{name}/{age}")
    public String update(@PathVariable long id,@PathVariable String name,@PathVariable int age){
        User user = userRepository.getOne(id);
        user.setName(name);
        user.setAge(age);
        userRepository.save(user);
        return  "update successful";
    }

    @RequestMapping("/get/{id}")
    public String get(@PathVariable long id){
        User user = userRepository.getOne(id);
        return user.toString();
    }

    @RequestMapping("/list")
    public List<User> list(){
        List<User> list = userRepository.findAll();
        return list;
    }

    @RequestMapping("/test")
    public String test(){
        return homeProperties.getDesc();
    }
}
