package com.teamvoy.cam.food2fork.entity;

import com.google.gson.annotations.SerializedName;

import lombok.Getter;

@Getter
public class RecipeDetailsData {

    @SerializedName("recipe")
    private RecipeDetails recipeDetails;

}
