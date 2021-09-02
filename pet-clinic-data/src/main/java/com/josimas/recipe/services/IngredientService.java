package com.josimas.recipe.services;

import com.josimas.recipe.commands.IngredientCommand;
import com.josimas.recipe.domain.Ingredient;

public interface IngredientService extends CrudService<Ingredient, Long> {
    IngredientCommand findByRecipeIdAndIngredientId(Long recipeId, Long ingredientId);

    IngredientCommand saveIngredientCommand(IngredientCommand command);

    void deleteById(Long recipeId, Long idToDelete);
}
