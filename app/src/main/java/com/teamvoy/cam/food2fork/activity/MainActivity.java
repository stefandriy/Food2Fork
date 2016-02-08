package com.teamvoy.cam.food2fork.activity;

import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.teamvoy.cam.food2fork.R;
import com.teamvoy.cam.food2fork.entity.Recipe;
import com.teamvoy.cam.food2fork.entity.RecipeDetails;
import com.teamvoy.cam.food2fork.entity.RecipeDetailsData;
import com.teamvoy.cam.food2fork.entity.RecipesData;
import com.teamvoy.cam.food2fork.recycler.CardItem;
import com.teamvoy.cam.food2fork.recycler.CardRecyclerAdapter;
import com.teamvoy.cam.food2fork.service.Food2ForkService;
import com.teamvoy.cam.food2fork.service.RestService;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

//public class MainActivity extends AppCompatActivity {
//
//    @Bind(R.id.text_view)
//    TextView textView;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//
//
//        RestService.instance().getRecipeDetails(RestService.API_KEY, "47024").enqueue(new Callback<RecipeDetailsData>() {
//            @Override
//            public void onResponse(Call<RecipeDetailsData> call, Response<RecipeDetailsData> response) {
//                RecipeDetails recipeDetails = response.body().getRecipeDetails();
////                mEmptyListProgressAnimation.setVisibility(View.GONE);
//                fillData(recipeDetails);
//            }
//
//            @Override
//            public void onFailure(Call<RecipeDetailsData> call, Throwable t) {
////                mEmptyListProgressAnimation.setVisibility(View.GONE);
//                finish();
//            }
//        });
//
//    }
//
//    void fillData (RecipeDetails recipeDetails) {
////        TextView textView = (TextView) findViewById(R.id.text_view);
//        textView.setText(recipeDetails.toString());
//    }
//
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);
//        return true;
//    }
//
//    @Override
//    public boolean onOptionsItemSelected(MenuItem item) {
//        // Handle action bar item clicks here. The action bar will
//        // automatically handle clicks on the Home/Up button, so long
//        // as you specify a parent activity in AndroidManifest.xml.
//        int id = item.getItemId();
//
//        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }
//
//        return super.onOptionsItemSelected(item);
//    }
//}
public class MainActivity extends AppCompatActivity {

    @Bind(R.id.recyclerView)
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        init();
    }



    private void init() {
//        viewPager.setAdapter(new CardRecyclerAdapter(this, getSupportFragmentManager()));

    }
    List<Recipe> recipesList = new ArrayList<>();

    private List<CardItem> getData () {
        List<CardItem> cardItemList = new ArrayList<>();
        Food2ForkService food2ForkService = RestService.instance();
        food2ForkService.searchRecipes(RestService.API_KEY, "r", 1, "").enqueue(new Callback<RecipesData>() {
            @Override
            public void onResponse(Call<RecipesData> call, Response<RecipesData> response) {
                RecipesData recipesData = response.body();
                        recipesList.addAll(recipesData.getRecipes());
            }

            @Override
            public void onFailure(Call<RecipesData> call, Throwable t) {

            }
        });
        for (Recipe recipe : recipesList) {
            cardItemList.add(new CardItem(recipe.getTitle(), recipe.getPublisher(),
                    recipe.getImageUrl(), recipe.getId(), recipe.getSocialRank()));
        }
        return cardItemList;
    }

}
