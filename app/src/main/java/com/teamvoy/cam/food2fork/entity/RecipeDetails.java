package com.teamvoy.cam.food2fork.entity;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import lombok.Getter;

@Getter
public class RecipeDetails extends Recipe {

    @SerializedName("ingredients")
    private List<String> ingredients;

    @SerializedName("source_url")
    private String sourceUrl;

    @SerializedName("f2f_url")
    private String f2fUrl;

    @SerializedName("publisher_url")
    private String publisherUrl;

    @Override
    public String toString() {
        return "RecipeDetails{" +
                "ingredients=" + ingredients +
                ", sourceUrl='" + sourceUrl + '\'' +
                ", f2fUrl='" + f2fUrl + '\'' +
                ", publisherUrl='" + publisherUrl + '\'' +
                '}';
    }
}
