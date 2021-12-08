/*
 * Created by Team 5 on 2021.11.15
 * Copyright © 2021 Team 5. All rights reserved.
 */

package edu.vt.ApiSearch;

import edu.vt.EntityBeans.User;
import edu.vt.EntityBeans.UserRecipe;
import edu.vt.FacadeBeans.UserRecipeFacade;
import edu.vt.controllers.PantryController;
import edu.vt.controllers.UserRecipeController;
import edu.vt.controllers.util.JsfUtil;
import edu.vt.globals.Constants;
import edu.vt.globals.Methods;
import org.primefaces.shaded.json.JSONArray;
import org.primefaces.shaded.json.JSONObject;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

@Named("recipeSearchController")
@SessionScoped
public class RecipeSearchController implements Serializable {
    private String query = null;
    private List<SearchedRecipe> listOfSearchedRecipes = null;
    private SearchedRecipe selected = null;

    @EJB
    UserRecipeFacade userRecipeFacade;

    @Inject
    private UserRecipeController service;

    public String getQuery() {
        return query;
    }

    public void setQuery(String query) {
        this.query = query;
    }

    public List<SearchedRecipe> getListOfSearchedRecipes() {
        return listOfSearchedRecipes;
    }

    public void setListOfSearchedRecipes(List<SearchedRecipe> listOfSearchedRecipes) {
        this.listOfSearchedRecipes = listOfSearchedRecipes;
    }

    public SearchedRecipe getSelected() {
        return selected;
    }

    public void setSelected(SearchedRecipe selected) {
        this.selected = selected;
    }

    public void clear() {
        query = null;
        selected = null;
    }


    private SearchedRecipe mapRecipe(JSONObject recipeObject) {
        JSONObject foundRecipe = recipeObject.getJSONObject("recipe");
        String name = foundRecipe.optString("label", "");
        if (name.equals("")) {
            // Skip the recipe with no name (label)
            return null;
        }
                    /*
                     ================
                     Recipe Image URL
                     ================
                     */
        String imageURL = foundRecipe.optString("image", "");
        if (imageURL.equals("")) {
            // Skip the recipe with no image URL
            return null;
        }
                    /*
                     =====================
                     Recipe Publisher Name
                     =====================
                     */
        String publisherName = foundRecipe.optString("source", "");
        if (publisherName.equals("")) {
            publisherName = "Publisher Unknown";
        }
                    /*
                     ==================
                     Recipe Website URL
                     ==================
                     */
        String recipeURL = foundRecipe.optString("url", "");
        if (recipeURL.equals("")) {
            // Skip the recipe with no website URL
            return null;
        }
               /*
                     ==================
                     Edamam Website URL
                     ==================
                     */
        String uri = foundRecipe.optString("uri", "");
        if (uri.equals("")) {
            // Skip the recipe with no website URL
            return null;
        }
                    /*
                     ==================
                     Recipe Diet Labels
                     ==================
                     */
        JSONArray dietLabelsAsArray = foundRecipe.getJSONArray("dietLabels");

        String dietLabels = "";
        int dietLabelsArrayLength = dietLabelsAsArray.length();

        if (dietLabelsArrayLength > 0) {
            for (int j = 0; j < dietLabelsArrayLength; j++) {
                String aDietLabel = dietLabelsAsArray.optString(j, "");
                if (j < dietLabelsArrayLength - 1) {
                    aDietLabel = aDietLabel + ", ";
                }
                dietLabels = dietLabels.concat(aDietLabel);
            }
        }
                    /*
                     ====================
                     Recipe Health Labels
                     ====================
                     */
        JSONArray healthLabelsAsArray = foundRecipe.getJSONArray("healthLabels");

        String healthLabels = "";
        int healthLabelsArrayLength = healthLabelsAsArray.length();

        if (healthLabelsArrayLength > 0) {
            for (int j = 0; j < healthLabelsArrayLength; j++) {
                String aHealthLabel = healthLabelsAsArray.optString(j, "");
                if (j < healthLabelsArrayLength - 1) {
                    aHealthLabel = aHealthLabel + ", ";
                }
                healthLabels = healthLabels.concat(aHealthLabel);
            }
        }
                /*
                     ====================
                     Recipe Health Labels
                     ====================
                     */
        JSONArray cautionsAsArray = foundRecipe.getJSONArray("cautions");

        String cautions = "";
        int cautionsAsArrayLength = healthLabelsAsArray.length();

        if (cautionsAsArrayLength > 0) {
            for (int j = 0; j < cautionsAsArrayLength; j++) {
                String aCaution = cautionsAsArray.optString(j, "");
                if (!aCaution.equals("")) {
                    if (cautions.equals("")) {
                        cautions = cautions.concat(aCaution);
                    } else {
                        cautions = cautions.concat(", " + aCaution);
                    }
                }
            }
        }
                    /*
                     =======================
                     Recipe Ingredient Lines
                     =======================
                     */
        JSONArray ingredientLinesAsArray = foundRecipe.getJSONArray("ingredientLines");

        String ingredientLines = "";
        int ingredientLinesArrayLength = ingredientLinesAsArray.length();

        if (ingredientLinesArrayLength > 0) {
            for (int j = 0; j < ingredientLinesArrayLength; j++) {
                String anIngredientLine = ingredientLinesAsArray.optString(j, "");
                if (j < ingredientLinesArrayLength - 1) {
                    anIngredientLine = anIngredientLine + ", ";
                }
                ingredientLines = ingredientLines.concat(anIngredientLine);
            }
        }
                    /*
                     ===============
                     Recipe Calories
                     ===============
                     */
        Double calories = foundRecipe.optDouble("calories", 0.0);
        /* Round the calories value to 2 decimal places */
        calories = round(calories);
                 /*
                     ===============
                     Recipe Nutrition
                     ===============
                     */
        JSONObject totalNutrients = foundRecipe.optJSONObject("totalNutrients");
        String nutrition = "Calories: " + calories;
        // iterator for iterating over the keys of the object.
        Iterator<String> keys = totalNutrients.keys();
        while (keys.hasNext()) {
            String key = keys.next();
            if (totalNutrients.get(key) instanceof JSONObject) {
                JSONObject nutrient = new JSONObject(totalNutrients.get(key).toString());
                String label = nutrient.optString("label", "");
                if (label.equals("")) {
                    continue;
                }
                Double quantity = nutrient.optDouble("quantity", 0.00);
                quantity = round(quantity);
                String unit = nutrient.optString("unit", "");
                if (unit.equals("")) {
                    continue;
                }
                String temp = ", " + label + ": " + quantity + unit;
                nutrition = nutrition.concat(temp);
            }
        }
        nutrition += ".";
        // iterate array to get the cuisine details and category of the recipe

        JSONArray categoryAsArray = foundRecipe.optJSONArray("dishType");

        String category = "";
        if (categoryAsArray != null) {
            int categoryArrayLength = ingredientLinesAsArray.length();
            if (categoryArrayLength > 0) {
                for (int j = 0; j < categoryArrayLength; j++) {
                    String aCategoryLine = categoryAsArray.optString(j, "");
                    if (j < categoryArrayLength - 1 && !aCategoryLine.equals("")) {
                        aCategoryLine = aCategoryLine + ", ";
                    }
                    category = category.concat(aCategoryLine);
                }
            }

        }


        String cuisine = "";
        JSONArray cuisineAsArray = foundRecipe.optJSONArray("cuisineType");
        if (cuisineAsArray != null) {
        int cuisineAsArrayLength = cuisineAsArray.length();

        if (cuisineAsArrayLength > 0) {
            for (int j = 0; j < cuisineAsArrayLength; j++) {
                String aCuisineLine = cuisineAsArray.optString(j, "");
                if (j < cuisineAsArrayLength - 1 && !aCuisineLine.equals("")) {
                    aCuisineLine = aCuisineLine + ", ";
                }
                cuisine = cuisine.concat(aCuisineLine);
            }
        }
        }

        return new SearchedRecipe(name, imageURL, ingredientLines, publisherName, nutrition, recipeURL, healthLabels, dietLabels, cautions, uri, category, cuisine);


    }

    public String performSearch() {
        selected = null;

        // This sets the necessary flag to ensure the messages are preserved.
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);


        // Spaces in search query must be replaced with "%20"
        String searchQuery = query.replaceAll(" ", "%20");

        try {
            //    https://api.edamam.com/api/recipes/v2?type=public&q=mutton%20&app_id=99b8644e&app_key=f52130770151d0b2a5cada889bf6ab3d&random=false
            this.apiSearch(searchQuery);

        } catch (Exception ex) {
            Methods.showMessage("Information", "No Results!", "No recipe found for the search query!");
        }
        return "/recipeSearch/ApiSearchResults?faces-redirect=true";
    }

    private Double round(Double value) {
        value = value * 100;
        value = (double) Math.round(value);
        value = value / 100;
        return value;
    }


    private String formatNutrientsQuery(ArrayList<String> selectedIngredients) {
        String formattedQuery = "";
        for (String str : selectedIngredients) {
            formattedQuery += " " + str;
        }
        return formattedQuery.trim();
    }

    private List<SearchedRecipe> apiSearch(String searchQuery) throws Exception {
        listOfSearchedRecipes = new ArrayList();
        String edamamUrl = Constants.EDAMAM_BASE_URL + searchQuery + "&app_id=" + Constants.EDAMAM_APP_ID + "&app_key=" + Constants.EDAMAM_API_KEY + "&random=false";

        // Obtain the JSON file (String of characters) containing the search results
        // The readUrlContent() method is given below
        String searchResultsJsonData = Methods.readUrlContent(edamamUrl);
        // The file returned from the API is in the form of a JSON object
        // Create a new JSON object from the returned file
        JSONObject searchResultsJsonObject = new JSONObject(searchResultsJsonData);
        // get link to get the next page.
        // make 2nd api call to get the list of recipes for the next page. (20 recipes per page)
        JSONObject links = searchResultsJsonObject.optJSONObject("_links");
        JSONObject next = links.optJSONObject("next");
        String nextPage = "";
        if (next != null) {
            nextPage = next.optString("href", "");
        }
        int index = 0;
        JSONArray hits = searchResultsJsonObject.getJSONArray("hits");
        while (index < hits.length()) {
            JSONObject jsonObject = hits.getJSONObject(index);
            SearchedRecipe recipe = mapRecipe(jsonObject);
            if (recipe != null) {
                listOfSearchedRecipes.add(recipe);
            }
            index++;
        }
        // make the second api for getting second page of recipes. In a single api call we only get 20 recipes. 2 api calls -> 40 (approx) recipes.
        if (!nextPage.equals("")) {
            String secondPageJsonData = Methods.readUrlContent(nextPage);
            JSONObject secondPageJsonObject = new JSONObject(secondPageJsonData);
            JSONArray secondPageHits = secondPageJsonObject.getJSONArray("hits");
            index = 0;
            while (index < secondPageHits.length()) {
                JSONObject jsonObject = secondPageHits.getJSONObject(index);
                SearchedRecipe recipe = mapRecipe(jsonObject);
                if (recipe != null) {
                    listOfSearchedRecipes.add(recipe);
                }
                index++;
            }
        }

        return listOfSearchedRecipes;

    }

    @Inject
    private PantryController pantryController;


    public String performIngredientRecipeSearch(ArrayList<String> selectedIngredients) {
        selected = null;

        // This sets the necessary flag to ensure the messages are preserved.
        FacesContext.getCurrentInstance().getExternalContext().getFlash().setKeepMessages(true);

        // Spaces in search query must be replaced with "%20"
        try {
            if (selectedIngredients.isEmpty()) {
                throw new IngredientsListEmptyException("INGREDIENTS_LIST_EMPTY");
            }
            query = this.formatNutrientsQuery(selectedIngredients);
            String searchQuery = query.replaceAll(" ", "%20");
            this.apiSearch(searchQuery);
            pantryController.setSelectedListOfIngredients(new ArrayList<String>());
        } catch (IngredientsListEmptyException ex) {
            Methods.showMessage("Information", "No Results!", "Please select at least one ingredient to search for recipes!");
        } catch (Exception ex) {
            Methods.showMessage("Information", "No Results!", "No recipe found for the search query!");
        }
        return "/recipeSearch/ApiSearchResults?faces-redirect=true";
    }

    private User getLoggedInUser() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        return (User) sessionMap.get("user");
    }

    public void save() {
        try {
            User user = this.getLoggedInUser();
            UserRecipe userRecipe = new UserRecipe();
            userRecipe.setName(this.selected.getName());
            userRecipe.setUserId(user);
            userRecipe.setCautions(this.selected.getCautions());
            userRecipe.setIngredients(this.selected.getIngredients());
            userRecipe.setImageUrl(this.selected.getImageUrl());
            userRecipe.setCategory(this.selected.getCategory());
            userRecipe.setCuisine(this.selected.getCuisine());
            userRecipe.setNutrients(this.selected.getNutrients());
            userRecipe.setSourceUrl(this.selected.getSourceUrl());
            userRecipe.setHealthLabels(this.selected.getHealthLabels());
            userRecipe.setDietLabels(this.selected.getDietLabels());
            userRecipe.setSource(this.selected.getSource());
            userRecipe.setDescription(this.selected.getName() + ", " + this.selected.getCategory() + ", " + this.selected.getCuisine() + ".");
            userRecipe.setUrl(this.selected.getUrl());
            userRecipeFacade.edit(userRecipe);
            JsfUtil.addSuccessMessage("Recipe was successfully saved!.");
            service.clear();
        } catch (EJBException ex) {
            String msg = "";
            Throwable cause = ex.getCause();
            if (cause != null) {
                msg = cause.getLocalizedMessage();
            }
            if (msg.length() > 0) {
                JsfUtil.addErrorMessage(msg);
            } else {
                JsfUtil.addErrorMessage(ex, "A persistence error occurred.");
            }
        } catch (Exception ex) {
            Logger.getLogger(this.getClass().getName()).log(Level.SEVERE, null, ex);
            JsfUtil.addErrorMessage(ex, "A persistence error occurred.");
        }
    }


}


//Custom exception class.
class IngredientsListEmptyException extends RuntimeException {
    IngredientsListEmptyException(String errorMessage) {
        super(errorMessage);
    }
}

