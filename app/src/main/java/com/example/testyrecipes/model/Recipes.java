package com.example.testyrecipes.model;

import java.util.List;

public class Recipes {

    private String name;
    private List<String> ingredients;
    private String instructions;
    private int imageResource;
    private String category;
    private String prepTime;
    private String cookTime;

    public Recipes() {
        this.name = name;
        this.ingredients = ingredients;
        this.instructions = instructions;
        this.imageResource = imageResource;
        this.category = category;
        this.prepTime = prepTime;
        this.cookTime = cookTime;
    }

    public String getName() {
        return name;
    }

    public List<String> getIngredients() {
        return ingredients;
    }

    public String getInstructions() {
        return instructions;
    }

    public int getImageResource() {
        return imageResource;
    }

    public String getCategory() {
        return category;
    }

    public String getPrepTime() {
        return prepTime;
    }

    public String getCookTime() {
        return cookTime;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setIngredients(List<String> ingredients) {
        this.ingredients = ingredients;
    }

    public void setInstructions(String instructions) {
        this.instructions = instructions;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrepTime(String prepTime) {
        this.prepTime = prepTime;
    }

    public void setCookTime(String cookTime) {
        this.cookTime = cookTime;
    }
}
