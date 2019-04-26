package guru.assignment.recipe.service;

import java.util.Set;

import org.springframework.stereotype.Service;

import guru.assignment.recipe.domain.Recipe;


public interface RecipeService {

	Set<Recipe> getRecipe();
}
