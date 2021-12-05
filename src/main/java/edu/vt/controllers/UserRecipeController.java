/*
 * Created by Ishaan Gulati on 2021.12.4
 * Copyright © 2021 Ishaan Gulati. All rights reserved.
 */

package edu.vt.controllers;

import edu.vt.globals.Methods;
import edu.vt.EntityBeans.User;
import edu.vt.ApiSearch.Nutrition;
import edu.vt.EntityBeans.UserPantry;
import edu.vt.controllers.util.JsfUtil;
import edu.vt.ApiSearch.SearchNutrients;
import edu.vt.FacadeBeans.UserPantryFacade;


import javax.ejb.EJB;
import java.util.Map;
import java.util.List;
import javax.ejb.EJBException;
import javax.inject.Named;
import java.io.Serializable;
import java.util.logging.Level;
import java.util.logging.Logger;
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
@Named("userRecipeController")

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

public class UserRecipeController implements Serializable{

}
