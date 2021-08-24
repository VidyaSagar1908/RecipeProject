package com.sample.demo.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sample.demo.beans.Recipe;

/**
 * Retrieves Data from tables with the help of JpaRepository
 * 
 * @author Vidya sagar
 */

public interface RecipeRepository extends JpaRepository<Recipe, Integer> {

}
