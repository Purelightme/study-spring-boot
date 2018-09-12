package com.example.demo.web;

import com.example.demo.dao.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/ftl")
public class HelloController {

    @RequestMapping(value = "/hello/{name}",method = RequestMethod.GET)
    public String hello(Model model, @PathVariable String name){

        List<User> userList = new ArrayList<User>();

        model.addAttribute("userList",userList);
        model.addAttribute("name",name);

        return "index";
    }

}
