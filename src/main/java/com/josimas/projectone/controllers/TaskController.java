package com.josimas.projectone.controllers;

import org.springframework.stereotype.Controller;

@Controller
public class TaskController {

    public String sayHello(){
        System.out.println("Hello tasks");

        return "Hi tasks";
    }

}
