package com.teamvoy.cam.food2fork.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

@Getter
public class RecipesData {

    @SerializedName("recipes")
    private List<Recipe> recipes;

}
