package com.josimas.projectone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("/pets")
@Controller
public class PetController {
    public String whichPetIsTheBest(){
        return "Dog";
    }
}
