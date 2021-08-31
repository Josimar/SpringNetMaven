package com.josimas.recipe.controllers;

import com.josimas.projectone.controllers.RecipeController;
import com.josimas.recipe.domain.Recipe;
import com.josimas.recipe.services.RecipeService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anySet;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;

public class IndexControllerTest {

    @Mock
    RecipeService recipeService;

    @Mock
    Model model;

    RecipeController controller;

    @BeforeEach
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        // controller = new RecipeController(recipeService);
    }

//    @Test
//    public void testMockMVC() throws Exception{
//        MockMvc mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
//
//        mockMvc.perform(get("/")).andExpect(status().isOk()).andExpect(view().name("index"));
//    }
//
//    @Test
//    public void getIndexPage() throws Exception{
//
//        Set<Recipe> recipes = new HashSet<>();
//        recipes.add(new Recipe());
//
//        Recipe recipe = new Recipe();
//        recipe.setId(1l);
//
//        recipes.add(new Recipe());
//
//        when(recipeService.getRecipes()).thenReturn(recipes);
//
//        ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
//
//        String viewName = controller.getIndexPage(model);
//
//        Assertions.assertEquals("index", viewName);
//        // verify(recipeService, times(1)).getRecipes(); // ToDo: resolver
//        verify(model, times(1)).addAttribute(eq("recipes"), anySet());
//        verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
//
//        Set<Recipe> setInController = argumentCaptor.getValue();
//        Assertions.assertEquals(2, setInController.size());
//    }

}
