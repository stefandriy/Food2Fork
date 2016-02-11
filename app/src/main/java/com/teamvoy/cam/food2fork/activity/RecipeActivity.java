package com.teamvoy.cam.food2fork.activity;

import android.os.Bundle;
import android.support.design.widget.CollapsingToolbarLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.teamvoy.cam.food2fork.R;
import com.teamvoy.cam.food2fork.entity.Recipe;
import com.teamvoy.cam.food2fork.entity.RecipeDetails;
import com.teamvoy.cam.food2fork.entity.RecipeDetailsData;
import com.teamvoy.cam.food2fork.service.RestService;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RecipeActivity extends AppCompatActivity {

    public static final String ARG_RECIPE = "arg_recipe";

    @Bind(R.id.recipe_toolbarIV)
    private ImageView toolbarIV;

    @Bind(R.id.titleView)
    private TextView titleTV;

    @Bind(R.id.recipe_ingredients)
    private TextView ingredientsTV;

    @Bind(R.id.toolbar_layout)
    private CollapsingToolbarLayout collapsingToolbarLayout;

    @Bind(R.id.recipe_pb)
    private ProgressBar pb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recipe);
        ButterKnife.bind(this);

    }
}
