
/*
 * Created by Team 5 on 2021.11.15
 * Copyright © 2021 Team 5. All rights reserved.
 */

package edu.vt.controllers;

import edu.vt.EntityBeans.Recipe;
import edu.vt.FacadeBeans.RecipeFacade;
import edu.vt.controllers.util.JsfUtil;
import edu.vt.controllers.util.JsfUtil.PersistAction;
import edu.vt.globals.Methods;

import javax.ejb.EJB;
import javax.ejb.EJBException;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;


/*
---------------------------------------------------------------------------
The @Named (javax.inject.Named) annotation indicates that the objects
instantiated from this class will be managed by the Contexts and Dependency
Injection (CDI) container. The name "recipeController" is used within
Expression Language (EL) expressions in JSF (XHTML) facelets pages to
access the properties and invoke methods of this class.
---------------------------------------------------------------------------
 */
@Named("recipeController")

/*
The @SessionScoped annotation preserves the values of the recipeController
object's instance variables across multiple HTTP request-response cycles
as long as the user's established HTTP session is alive.
 */
@SessionScoped

/*
-----------------------------------------------------------------------------
Marking the RecipeController class as "implements Serializable" implies that
instances of the class can be automatically serialized and deserialized. 

Serialization is the process of converting a class instance (object)
from memory into a suitable format for storage in a file or memory buffer, 
or for transmission across a network connection link.

Deserialization is the process of recreating a class instance (object)
in memory from the format under which it was stored.
-----------------------------------------------------------------------------
 */
public class RecipeController implements Serializable {
    /*
    ===============================
    Instance Variables (Properties)
    ===============================
    */

    /*
    The @EJB annotation directs the EJB Container Manager to inject (store) the object reference of the
    RecipeFacade bean into the instance variable 'recipeFacade' after it is instantiated at runtime.
     */
    @EJB
    private RecipeFacade recipeFacade;

    // List of object references of Recipe  objects
    private List<Recipe> listOfRecipes = null;

    // selected = object reference of a selected Recipe object
    private Recipe selected;
//
//    // Flag indicating if Recipe data changed or not
//    private Boolean recipeDataChanged;

    // searchItems = List of object references of Recipe objects found in the search
//    private List<Recipe> searchItems = null;

//    // searchField refers to searching Recipe name,category, cuisine, publisher name individually or search in each field
//    private String searchField;
//
//    // searchString contains the character string the user entered for searching the selected searchField
//    private String searchString;
//
//    // Search type from 1 to 6
//    private Integer searchType;

//    public Integer getSearchType() {
//        return searchType;
//    }
//
//    public void setSearchType(Integer searchType) {
//        this.searchType = searchType;
//    }

    // Search Query Variables (Q = Query)
    private String name;
    private String source;
    private String sourceUrl;
    private String category;
    private String cuisine;
    private String url;
    private String imageUrl;
    private String nutrients;
    private String ingredients;

    /*
        =========================
        Getter and Setter Methods
        =========================
         */

//    public Boolean getRecipeDataChanged() {
//        return recipeDataChanged;
//    }
//
//    public void setRecipeDataChanged(Boolean recipeDataChanged) {
//        this.recipeDataChanged = recipeDataChanged;
//    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getNutrients() {
        return nutrients;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public List<Recipe> getListOfRecipes() {
        if (listOfRecipes == null) {
            listOfRecipes = recipeFacade.findAll();
        }
        return listOfRecipes;
    }

    public Recipe getSelected() {
        return selected;
    }

    public void setSelected(Recipe selected) {
        this.selected = selected;
    }


    // getSearchItems() is given at the bottom
//
//    public String getSearchField() {
//        return searchField;
//    }
//
//    public void setSearchField(String searchField) {
//        this.searchField = searchField;
//    }
//
//    public String getSearchString() {
//        return searchString;
//    }
//
//    public void setSearchString(String searchString) {
//        this.searchString = searchString;
//    }




/*
     ****************************************
     *   Unselect Selected Recipe Object   *
     ****************************************
     */
    public void unselect() {
        selected = null;
    }
//
//    /*
//     *************************************
//     *   Cancel and Display List.xhtml   *
//     *************************************
//     */
//    public String cancel() {
//        // Unselect previously selected recipe object if any
//        selected = null;
//        return "/Recipe/List?faces-redirect=true";
    }










