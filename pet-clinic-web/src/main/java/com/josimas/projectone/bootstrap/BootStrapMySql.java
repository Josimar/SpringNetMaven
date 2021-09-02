package com.josimas.projectone.bootstrap;

import com.josimas.recipe.domain.Category;
import com.josimas.recipe.domain.UnitOfMeasure;
import com.josimas.recipe.repositories.CategoryRepository;
import com.josimas.recipe.repositories.UnitOfMeasureRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationListener;
import org.springframework.context.annotation.Profile;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@Profile({"dev", "prod"})
public class BootStrapMySql implements ApplicationListener<ContextRefreshedEvent> {

//    private final CategoryRepository categoryRepository;
//    private final UnitOfMeasureRepository unitOfMeasureRepository;
//
//    public BootStrapMySql(CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
//        this.categoryRepository = categoryRepository;
//        this.unitOfMeasureRepository = unitOfMeasureRepository;
//    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        log.debug("ProjectOne -> BootstrapMySql -> onApplicationEvent");
//        if (categoryRepository.count() == 0L){
//            log.debug("Loading categories");
//            loadCategories();
//        }
//
//        if (unitOfMeasureRepository.count() == 0){
//            log.debug("Loading UOMs");
//            loadUom();
//        }
    }

//    private void loadCategories(){
//        Category cat1 = new Category();
//        cat1.setDescription("American");
//        categoryRepository.save(cat1);
//
//        Category cat2 = new Category();
//        cat2.setDescription("Italian");
//        categoryRepository.save(cat2);
//
//        Category cat3 = new Category();
//        cat3.setDescription("Mexican");
//        categoryRepository.save(cat3);
//
//        Category cat4 = new Category();
//        cat4.setDescription("Fast Food");
//        categoryRepository.save(cat4);
//    }
//
//    private void loadUom(){
//        UnitOfMeasure uom1 = new UnitOfMeasure();
//        uom1.setDescription("Teaspoon");
//        unitOfMeasureRepository.save(uom1);
//
//        UnitOfMeasure uom2 = new UnitOfMeasure();
//        uom2.setDescription("Tablespoon");
//        unitOfMeasureRepository.save(uom2);
//
//        UnitOfMeasure uom3 = new UnitOfMeasure();
//        uom3.setDescription("Cup");
//        unitOfMeasureRepository.save(uom3);
//    }
}
