package com.josimas.recipe.services.map;

import com.josimas.recipe.domain.Recipe;
import com.josimas.recipe.repositories.RecipeRepository;
import com.josimas.recipe.services.RecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Slf4j
@Service
@Profile({"default", "map"})
public class RecipeServiceMap extends AbstractMapService<Recipe, Long> implements RecipeService {

    private final RecipeRepository recipeRepository;

    public RecipeServiceMap(RecipeRepository recipeRepository) {
        this.recipeRepository = recipeRepository;
    }

    @Override
    public Set<Recipe> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Recipe object) {
        super.delete(object);
    }

    @Override
    public Recipe save(Recipe object) {
        return super.save(object);
    }

    @Override
    public Recipe findById(Long id) {
        return super.findById(id);
    }

    @Override
    public Set<Recipe> getRecipes() {
        log.debug("RecipeServiceMap -> I am a service");

        Set<Recipe> recipeSet = new HashSet<>();
        recipeRepository.findAll().iterator().forEachRemaining(recipeSet::add);
        return recipeSet;
    }
}
