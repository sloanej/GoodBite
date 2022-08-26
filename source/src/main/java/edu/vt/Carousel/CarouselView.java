
/*
 * Created by Team 5 on 2021.11.15
 * Copyright © 2021 Team 5. All rights reserved.
 */
package edu.vt.Carousel;

import edu.vt.EntityBeans.Recipe;
import edu.vt.FacadeBeans.RecipeFacade;
import edu.vt.galleria.Photo;
import edu.vt.galleria.PhotoService;
import org.primefaces.model.ResponsiveOption;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
@Named

/*
The @SessionScoped annotation preserves the values of the recipeController
object's instance variables across multiple HTTP request-response cycles
as long as the user's established HTTP session is alive.
 */
@SessionScoped

public class CarouselView implements Serializable {

    @EJB
    private RecipeFacade recipeFacade;

    // List of object references of Recipe  objects
    private List<Recipe> listOfRecipes = null;
    public List<Recipe> getListOfRecipes() {
        if (listOfRecipes == null) {
            listOfRecipes = recipeFacade.findAll();
        }
        return listOfRecipes;
    }

    private List<ResponsiveOption> responsiveOptions;

//    @Inject
//    private Recipe service;

    @PostConstruct
    public void init() {
        listOfRecipes = getListOfRecipes();
        responsiveOptions = new ArrayList<>();
        responsiveOptions.add(new ResponsiveOption("1024px", 3, 3));
        responsiveOptions.add(new ResponsiveOption("768px", 2, 2));
        responsiveOptions.add(new ResponsiveOption("560px", 1, 1));
    }


    public List<ResponsiveOption> getResponsiveOptions() {
        return responsiveOptions;
    }

    public void setResponsiveOptions(List<ResponsiveOption> responsiveOptions) {
        this.responsiveOptions = responsiveOptions;
    }
}