/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import BL.Menu;
import BL.Recipe;
import BL.User;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author fabaz
 */
public interface RecipeDAO {

    public ArrayList<String> getTypes();

    public void createRecipe(Recipe recipe, User user);
    
    public ArrayList<Recipe> getRecipes();
    
    public Recipe getRecipe(String name);

    public ArrayList<Recipe> getRecipes(String name, String type, int timeMax);

    public ArrayList<Recipe> getRecipes(String name, String type, int timeMax, User connectedUser);
    
    public ArrayList<Recipe> getAllRecipeFromMenu(Menu menu) throws SQLException;

    public void deleteRecipe(Recipe recipe);

    public void deleteIngredients(Recipe recipe);

    public void editRecipe(Recipe recipe);

    public void insertIngredients(Recipe recipe);
}
