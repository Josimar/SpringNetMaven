package com.josimas.projectone.controllers;

import com.josimas.projectone.model.Emprego;
import com.josimas.projectone.repository.EmpregoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
public class EmpregoController {

    @Autowired
    EmpregoRepository empregoRepository;

    @RequestMapping("/empregos")
    public String listaEmpregos(Model model)
    {
        model.addAttribute("empregos", empregoRepository.findAll());

        return "empregoList";
    }

    @GetMapping("/addemprego")
    public String addEmprego(Model model)
    {
        model.addAttribute("emprego", new Emprego());
        return "empregoForm";
    }

    @PostMapping("/saveemprego")
    public String saveEmprego(@Valid Emprego emprego, BindingResult result)
    {
        if (result.hasErrors()){
            return "empregoForm";
        }
        empregoRepository.save(emprego);
        return "redirect:/";
    }
}
