package com.sample.demo.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.sample.demo.beans.Recipe;
import com.sample.demo.dao.RecipeRepository;
import com.sample.demo.exceptions.ResourceNotFoundException;
import com.sample.demo.util.LocalDateAndTime;

/**
 * Contains methods to perform CRUD operations for the Recipe..
 * 
 * @author Vidya sagar
 */

@RestController
public class RecipeController {

	@Autowired
	RecipeRepository recipeRepository;

	/**
	 * Returns List of all the recipes which are present in the Recipe table
	 * 
	 * @return - List of Recipes
	 */
	@GetMapping(value = "/recipes", headers = "Accept=application/json")
	public List<Recipe> getRecipesList() {
		return recipeRepository.findAll();

	}

	/**
	 * Returns a single Recipe details by providing its RecipeId
	 * 
	 * @param id - Recipe id of the recipe
	 * @return - single record of the recipe
	 */
	@GetMapping(value = "/recipe/{id}", headers = "Accept=application/json")
	public Recipe getSingleRecipe(@PathVariable int id) {

		Recipe recipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe Not found with given id " + id));

		return recipe;
	}

	/**
	 * Inserts the record of recipe details along with Ingredients and returns
	 * Recipe record
	 * 
	 * @param recipe - All the details of recipe like name,type,ingredients etc.,.
	 * @return - inserted record will be returned
	 */
	@PostMapping("/recipe")
	public Recipe insertRecipe(@Valid @RequestBody Recipe recipe) {

		LocalDateAndTime dateTime = new LocalDateAndTime();

		recipe.setCreationDate(dateTime.getLocalDateTime());

		return recipeRepository.save(recipe);

	}

	/**
	 * Updates the record of recipe details along with Ingredients and returns
	 * Recipe record
	 * 
	 * @param recipe - All the details of recipe like name,type,ingredients etc.,.
	 * @param id     - Recipe id of the recipe
	 * @return - updated record will be returned
	 */
	@PutMapping("/recipe/{id}")
	public Recipe updateRecipe(@Valid @RequestBody Recipe recipe, @PathVariable int id) {

		Recipe existingRecipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe Not found with given id " + id));

		existingRecipe.setRecipeName(recipe.getRecipeName());
		existingRecipe.setNoOfPeople(recipe.getNoOfPeople());
		existingRecipe.setIngredients(recipe.getIngredients());
		existingRecipe.setInstructions(recipe.getInstructions());
		existingRecipe.setRecipeType(recipe.getRecipeType());

		return recipeRepository.save(existingRecipe);

	}

	/**
	 * Deletes the record of recipe details along with Ingredients by using recipe
	 * ID
	 * 
	 * @param id - Recipe id of the recipe
	 * @return - returns HTTP response as OK
	 */
	@DeleteMapping("/recipe/{id}")
	public ResponseEntity<Recipe> deleteRecipe(@PathVariable int id) {

		Recipe existingRecipe = recipeRepository.findById(id)
				.orElseThrow(() -> new ResourceNotFoundException("Recipe Not found with given id " + id));

		recipeRepository.delete(existingRecipe);

		return ResponseEntity.ok().build();
	}

}
