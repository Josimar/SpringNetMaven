package com.josimas.recipe.services.map;

import com.josimas.recipe.domain.Category;
import com.josimas.recipe.services.CategoryService;
import org.springframework.stereotype.Service;

import java.util.Set;

@Service
public class CategoryMapService extends AbstractMapService<Category, Long> implements CategoryService {

    @Override
    public Set<Category> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Category object) {
        super.delete(object);
    }

    @Override
    public Category save(Category object) {
        return super.save(object);
    }

    @Override
    public Category findById(Long id) {
        return super.findById(id);
    }
}
