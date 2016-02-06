package com.teamvoy.cam.food2fork.entity;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

import lombok.Getter;

@Getter
public class Recipe implements Serializable{

    @SerializedName("publisher")
    private String publisher;

    @SerializedName("title")
    private String title;

    @SerializedName("recipe_id")
    private String id;

    @SerializedName("social_rank")
    private String socialRank;

    @SerializedName("image_url")
    private String imageUrl;

}
