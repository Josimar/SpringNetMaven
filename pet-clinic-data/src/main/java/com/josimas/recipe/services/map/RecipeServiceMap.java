package com.josimas.recipe.services.map;

import com.josimas.recipe.domain.Recipe;
import com.josimas.recipe.services.RecipeService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class RecipeServiceMap extends AbstractMapService<Recipe, Long> implements RecipeService {
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
}
