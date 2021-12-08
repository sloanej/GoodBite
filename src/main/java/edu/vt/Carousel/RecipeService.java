/*
 * Created by Team 5 on 2021.11.15
 * Copyright © 2021 Team 5. All rights reserved.
 */
//package edu.vt.Carousel;
//
//import edu.vt.EntityBeans.Recipe;
//import edu.vt.FacadeBeans.RecipeFacade;
//import edu.vt.galleria.Photo;
//import edu.vt.galleria.PhotoService;
//import org.primefaces.model.ResponsiveOption;
//
//import javax.annotation.PostConstruct;
//import javax.ejb.EJB;
//import javax.enterprise.context.SessionScoped;
//import javax.faces.context.FacesContext;
//import javax.faces.view.ViewScoped;
//import javax.inject.Inject;
//import javax.inject.Named;
//import java.io.Serializable;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.Map;
//import java.util.Random;
//
//@Named
//
///*
//The @SessionScoped annotation preserves the values of the recipeController
//object's instance variables across multiple HTTP request-response cycles
//as long as the user's established HTTP session is alive.
// */
//@SessionScoped
//
//
//public class RecipeService {
//    @EJB
//    private RecipeFacade recipeFacade;
//
//    private List<Recipe> listOfRecipes = null;
//
//    public List<Recipe> getListOfRecipes() {
//        if (listOfRecipes == null) {
//            listOfRecipes = recipeFacade.findAll();
//        }
//        return listOfRecipes;
//    }
//
//        @PostConstruct
//        public void init() {
//        }
//
