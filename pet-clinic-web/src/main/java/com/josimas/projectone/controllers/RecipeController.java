package com.josimas.projectone.controllers;

import com.josimas.recipe.domain.Category;
import com.josimas.recipe.domain.UnitOfMeasure;
import com.josimas.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Slf4j
@RequestMapping("/recipes")
@Controller
public class RecipeController {

    /*
    private final RecipeService recipeService;

    public RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }
    */

    @RequestMapping({"", "/", "recipes"})
    public String getIndexPage(Model model){
        log.debug("Controller RecipeController => getIndexPage");

        model.addAttribute("recipes", "recipeService");

        return "recipe";
    }
}
