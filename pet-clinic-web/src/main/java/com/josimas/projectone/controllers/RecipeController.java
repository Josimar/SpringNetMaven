package com.josimas.projectone.controllers;

import com.josimas.recipe.repositories.RecipeRepository;
import com.josimas.recipe.services.RecipeService;
import com.josimas.recipe.services.map.RecipeServiceMap;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
public class RecipeController {

    /*
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
     */

    @RequestMapping({"", "/", "recipe", "recipes"})
    public String getIndexPage(Model model){

        log.debug("Controller RecipeController => getIndexPage");

        model.addAttribute("recipes", ""); // recipeService.findAll()); ToDo: error beans

        return "recipe";
    }

    @RequestMapping("/recipe/show/{id}")
    public String showById(@PathVariable String id, Model model){
//        model.addAttribute("recipe", recipeService.findById(new Long(id)));

        return "recipe/show";
    }
}
