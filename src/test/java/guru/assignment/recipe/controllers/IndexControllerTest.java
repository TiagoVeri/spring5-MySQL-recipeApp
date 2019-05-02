package guru.assignment.recipe.controllers;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.HashSet;
import java.util.Set;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.ui.Model;

import guru.assignment.recipe.domain.Recipe;
import guru.assignment.recipe.service.RecipeService;

public class IndexControllerTest {

	@Mock
	RecipeService recipeService;
	
	@Mock
	Model model;
	
	IndexController controller;
	
	
	@Before
	public void setUp() throws Exception{
		MockitoAnnotations.initMocks(this);

		controller = new IndexController(recipeService);
	}
	@Test
	public void testGetIndexPage() throws Exception{

		//given
		Set<Recipe> recipes = new HashSet<>();
		recipes.add(new Recipe());
		
		Recipe recipe = new Recipe();
		recipe.setId(1L);
		
		recipes.add(recipe);
		
		when(recipeService.getRecipe()).thenReturn(recipes);
		
		ArgumentCaptor<Set<Recipe>> argumentCaptor = ArgumentCaptor.forClass(Set.class);
		
		//when
		String viewName = controller.getIndexPage(model);
		
		//then
		//Verify if getIndexPage returns "index"
		assertEquals("index", viewName);
		
		//Verifying  interations with mock
		verify(recipeService, times(1)).getRecipe();
		
		verify(model, times(1)).addAttribute(eq("recipes"), argumentCaptor.capture());
		
		Set<Recipe> setInController = argumentCaptor.getValue();
		assertEquals(2, setInController.size());
		
		
		
	}

}
