/*
 * Created by Team 5 on 2021.11.15
 * Copyright © 2021 Team 5. All rights reserved.
 */

package edu.vt.ApiSearch;

public class SearchedRecipe {
    private String name;
    private String imageUrl;
    private String ingredients;
    private String source;
    private String nutrients;
    private String sourceUrl;
    private String healthLabels;
    private String dietLabels;
    private String cautions;
    private String url;
    private String category;
    private String cuisine;


    public SearchedRecipe(String name, String imageUrl, String ingredients, String source, String nutrients, String sourceUrl, String healthLabels, String dietLabels, String cautions, String url, String category, String cuisine) {
        this.name = name;
        this.imageUrl = imageUrl;
        this.ingredients = ingredients;
        this.source = source;
        this.nutrients = nutrients;
        this.sourceUrl = sourceUrl;
        this.healthLabels = healthLabels;
        this.dietLabels = dietLabels;
        this.cautions = cautions;
        this.url = url;
        this.category = category;
        this.cuisine = cuisine;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getIngredients() {
        return ingredients;
    }

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getNutrients() {
        return nutrients;
    }

    public void setNutrients(String nutrients) {
        this.nutrients = nutrients;
    }

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }

    public String getHealthLabels() {
        return healthLabels;
    }

    public void setHealthLabels(String healthLabels) {
        this.healthLabels = healthLabels;
    }

    public String getDietLabels() {
        return dietLabels;
    }

    public void setDietLabels(String dietLabels) {
        this.dietLabels = dietLabels;
    }

    public String getCautions() {
        return cautions;
    }

    public void setCautions(String cautions) {
        this.cautions = cautions;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
}
