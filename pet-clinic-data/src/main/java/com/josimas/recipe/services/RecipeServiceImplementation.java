package com.josimas.recipe.services;

import com.josimas.recipe.domain.Recipe;
import com.josimas.recipe.repositories.RecipeRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Slf4j
@Service
public class RecipeServiceImplementation implements RecipeService{

    private final RecipeRepository recipeRepository;

    public RecipeServiceImplementation(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("Class RecipeServiceImplementation => I am in the service");
        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }

    @Override
    public Set<Recipe> findAll() {
        return null;
    }

    @Override
    public Recipe findById(Long aLong) {
        Optional<Recipe> recipeOptional = recipeRepository.findById(aLong);

        if (!recipeOptional.isPresent()){
            throw  new RuntimeException("Recipe not found!");
        }

        return recipeOptional.get();
    }

    @Override
    public Recipe save(Recipe object) {
        return null;
    }

    @Override
    public void delete(Recipe object) {

    }

    @Override
    public void deleteById(Long aLong) {

    }
}
