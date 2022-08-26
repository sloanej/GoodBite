/*
 * Created by Team 5 on 2021.12.6
 * Copyright © 2021 Team 5. All rights reserved.
 */

package edu.vt.managers;

import edu.vt.EntityBeans.User;
import edu.vt.EntityBeans.UserRecipe;
import edu.vt.controllers.UserRecipeController;
import org.primefaces.component.datatable.DataTable;
import org.primefaces.component.export.Exporter;

import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;

@Named
@ViewScoped
public class DataExporterView implements Serializable {

    private List<UserRecipe> recipes;

    private Exporter<DataTable> textExporter;

    @Inject
    private UserRecipeController service;

    @PostConstruct
    public void init() {
        recipes = service.getListOfRecipes();
        textExporter = new TextExporter();
    }

    public List<UserRecipe> getRecipes() {
        return recipes;
    }

    public void setService(UserRecipeController service) {
        this.service = service;
    }

    public Exporter<DataTable> getTextExporter() {
        return textExporter;
    }

    public void setTextExporter(Exporter<DataTable> textExporter) {
        this.textExporter = textExporter;
    }

}