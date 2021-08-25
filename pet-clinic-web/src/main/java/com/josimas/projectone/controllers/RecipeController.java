package com.josimas.projectone.controllers;

import com.josimas.recipe.domain.Category;
import com.josimas.recipe.domain.UnitOfMeasure;
import com.josimas.recipe.repositories.CategoryRepository;
import com.josimas.recipe.repositories.UnitOfMeasureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class RecipeController {

    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeController(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @RequestMapping("/recipe")
    public String getRecipe(){
        Optional<Category> categoryOptional = categoryRepository.findByDescription("American");
        Optional<UnitOfMeasure> unitOfMeasureOptional = unitOfMeasureRepository.findByDescription("Teaspoon");

        System.out.println("Category id: " + categoryOptional.get().getId());
        System.out.println("Unit id: " + unitOfMeasureOptional.get().getId());

        return "recipe";
    }

}
