package com.example.testyrecipes.activities;

import android.os.Bundle;
import android.util.Log;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.testyrecipes.R;
import com.example.testyrecipes.adapter.RecyclerViewAdapter;
import com.example.testyrecipes.model.Recipes;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private final String JSON_URL = "https://run.mocky.io/v3/de149fc9-f844-4909-865b-73d20de75dc3";
    private JsonArrayRequest request ;
    private RequestQueue requestQueue ;
    private List<Recipes> lstRecipes = new ArrayList<>();
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);


        lstRecipes = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerView);
        jsonrequest();

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }

    private void jsonrequest() {

        request = new JsonArrayRequest(JSON_URL, new Response.Listener<JSONArray>() {
            @Override
            public void onResponse(JSONArray response) {
                JSONObject jsonObject = null;

                for (int i = 0 ; i < response.length();i++){


                    try {
                        jsonObject = response.getJSONObject(i);
                        Recipes recipes = new Recipes();
                        recipes.setName(jsonObject.getString("name"));
                        recipes.setIngredients(Collections.singletonList(jsonObject.getString("ingredients")));
                        recipes.setInstructions(jsonObject.getString("instructions"));
                        recipes.setImageResource(Integer.parseInt(jsonObject.getString("imageResource")));
                        recipes.setCategory(jsonObject.getString("category"));
                        recipes.setPrepTime(jsonObject.getString("prep_time"));
                        recipes.setCookTime(jsonObject.getString("cook_time"));
                        lstRecipes.add(recipes);

                    } catch (JSONException e) {
                        throw new RuntimeException(e);
                    }

                }
                setuprecyclerview(lstRecipes);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.e("VOLLEY_ERROR", "Error fetching JSON data: " + volleyError.getMessage());
            }
        });

        requestQueue = Volley.newRequestQueue(MainActivity.this);
        requestQueue.add(request);

    }

    private void setuprecyclerview(List<Recipes> lstRecipes) {

        RecyclerViewAdapter myadapter = new RecyclerViewAdapter(this,lstRecipes);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        recyclerView.setAdapter(myadapter);
    }
}