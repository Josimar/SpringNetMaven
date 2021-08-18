package com.josimas.projectone.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping("/login")
    public String login()
    {
        return "login";
    }

    @RequestMapping("/")
    public String index()
    {
        return "index";
    }

    @RequestMapping("/admin")
    public String admin()
    {
        return "admin";
    }

    @RequestMapping("/secure")
    public String secure(){
        return "secure";
    }

    @RequestMapping("/mensagem")
    public String homeApp(Model model)
    {
        model.addAttribute("mensagem", "Mensagem injetada pelo controller");

        return "index";
    }

    @RequestMapping("/home")
    public String home()
    {
        return "home";
    }

    @RequestMapping("/blog")
    public String blog()
    {
        return "blog";
    }

    @RequestMapping("/contact")
    public String contact()
    {
        return "contact";
    }

}
