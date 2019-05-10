package guru.assignment.recipe.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.view;
import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;

import guru.assignment.recipe.domain.Recipe;
import guru.assignment.recipe.service.RecipeService;

public class RecipeControllerTest {

	@Mock
	RecipeService recipeService;
	
	RecipeController controller;
	
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);

		controller = new RecipeController(recipeService);
	}
	

	@Test
	public void testGetRecipe() throws Exception{
		
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		MockMvc mockMvc= MockMvcBuilders.standaloneSetup(controller).build();
		
		when(recipeService.findById(anyLong())).thenReturn(recipe);
		
		mockMvc.perform(get("/recipe/show/1"))
				.andExpect(status().isOk())
				.andExpect(view().name("recipe/show"))
				.andExpect(model().attributeExists("recipe"));
		
		
	}

}
