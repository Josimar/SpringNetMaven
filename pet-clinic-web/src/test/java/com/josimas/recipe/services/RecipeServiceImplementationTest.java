package com.josimas.recipe.services;

import com.josimas.recipe.domain.Recipe;
import com.josimas.recipe.repositories.RecipeRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class RecipeServiceImplementationTest {

    RecipeServiceImplementation recipeServiceImplementation;

    @Mock
    RecipeRepository recipeRepository;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        recipeServiceImplementation = new RecipeServiceImplementation(recipeRepository);
    }

    @Test
    public void getRecipes() throws Exception{
        Recipe recipe = new Recipe();
        HashSet recipesData = new HashSet();
        recipesData.add(recipe);

        // when(recipeServiceImplementation.getRecipes()).thenReturn(recipesData);
        when(recipeRepository.findAll()).thenReturn(recipesData);

        Set<Recipe> recipes = recipeServiceImplementation.getRecipes();

        Assertions.assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
    }

}
