package com.josimas.recipe.services;

import com.josimas.projectone.services.CrudService;
import com.josimas.recipe.commands.RecipeCommand;
import com.josimas.recipe.domain.Recipe;

import java.util.Set;

public interface RecipeService extends CrudService<Recipe, Long> {

    Set<Recipe> getRecipes();

    Recipe findById(Long l);

    RecipeCommand findCommandById(Long l);

    RecipeCommand saveRecipeCommand(RecipeCommand command);

    void deleteById(Long idToDelete);

}
