

/*
 * Created by Neha Surana on 2021.11.1
 * Copyright © 2021 Neha Surana. All rights reserved.
 */

package edu.vt.controllers;

import edu.vt.EntityBeans.User;
import edu.vt.EntityBeans.Recipe;
import edu.vt.EntityBeans.UserPantry;
import edu.vt.FacadeBeans.UserPantryFacade;


import javax.ejb.EJB;
import java.util.Map;
import java.util.List;
import javax.inject.Named;
import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.enterprise.context.SessionScoped;


/*
---------------------------------------------------------------------------
The @Named (javax.inject.Named) annotation indicates that the objects
instantiated from this class will be managed by the Contexts and Dependency
Injection (CDI) container. The name "recipeController" is used within
Expression Language (EL) expressions in JSF (XHTML) facelets pages to
access the properties and invoke methods of this class.
---------------------------------------------------------------------------
 */
@Named("pantryController")

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
public class PantryController implements Serializable {
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
    private UserPantryFacade pantryFacade;

    // List of object references of Recipe  objects
    private List<UserPantry> listOfIngredients = null;

    // selected = object reference of a selected Recipe object
    private UserPantry selected;
    private List<UserPantry> selectedIngredients;

    public void setListOfIngredients(List<UserPantry> listOfIngredients) {
        this.listOfIngredients = listOfIngredients;
    }

    public UserPantry getSelected() {
        return selected;
    }

    public void setSelected(UserPantry selected) {
        this.selected = selected;
    }

    public List<UserPantry> getSelectedIngredients() {
        return selectedIngredients;
    }

    public void setSelectedIngredients(List<UserPantry> selectedIngredients) {
        this.selectedIngredients = selectedIngredients;
    }

    public List<UserPantry> getListOfIngredients() {
        // get Logged in user.
        // get check if the list is null or not
        // if null then fetch the results
        // else return the result.
        if (listOfIngredients == null) {
            User user = this.getLoggedInUser();
            listOfIngredients = pantryFacade.findUserPantryByUserId(user.getId());
        }
        return listOfIngredients;
    }


    private User getLoggedInUser() {
        Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
        User signedInUser = (User) sessionMap.get("user");
        return signedInUser;
    }
    public void unselect() {
        this.selected = null;
    }
}










