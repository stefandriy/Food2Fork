package com.teamvoy.cam.food2fork.service;

import com.teamvoy.cam.food2fork.entity.RecipeDetailsData;
import com.teamvoy.cam.food2fork.entity.RecipesData;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface Food2ForkService {

    @GET("api/search")
    Call<RecipesData> searchRecipes(@Query("key") String apiKey, @Query("sort") String sort,
                                    @Query("page") Integer pageNum, @Query("q") String searchQuery);

    @GET("/api/get")
    Call<RecipeDetailsData> getRecipeDetails(@Query("key") String apiKey, @Query("rId") String id);
}
