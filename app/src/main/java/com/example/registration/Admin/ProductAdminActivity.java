package com.example.registration.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.registration.R;
import com.example.registration.User.MainActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.util.ArrayList;
import java.util.List;

public class ProductAdminActivity extends AppCompatActivity {
    private static  final String PRODUCT_URL = "http://192.168.1.179/Mobu/retrieve.php";
    private RecyclerView recyclerView;
    private ProductAdapter adapter;
    private List<ProductA> productList;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private ProgressBar progressBar;

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        if (item.getItemId() == R.id.Home){

            intent = new Intent(ProductAdminActivity.this, HomeAdminActivity.class);
            startActivity(intent);
            Toast.makeText(ProductAdminActivity.this,"Home!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.Product){

            intent = new Intent(ProductAdminActivity.this, ProductAdminActivity.class);
            startActivity(intent);
            Toast.makeText(ProductAdminActivity.this,"Product!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.User){

            intent = new Intent(ProductAdminActivity.this, AccountAdminActivity.class);
            startActivity(intent);
            Toast.makeText(ProductAdminActivity.this,"Account!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.Logout){

            intent = new Intent(ProductAdminActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(ProductAdminActivity.this,"Log Out!",Toast.LENGTH_SHORT).show();
        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboardadmin_menu,menu);
        return true;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_admin);
        mToolbar = findViewById(R.id.dashboard_toolbar);
        progressBar = findViewById(R.id.progressbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        productList = new ArrayList<>();
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        loadProducts();
    }

        private void loadProducts(){
            StringRequest stringRequest = new StringRequest(Request.Method.GET, PRODUCT_URL,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            try {
                                JSONArray products  = new JSONArray(response);

                                for(int i=0;i<products.length();i++){
                                    JSONObject productObject = products.getJSONObject(i);
                                    String id = productObject.getString("id");
                                    String title = productObject.getString("title");
                                    double price = productObject.getDouble("price");
                                    double rating = productObject.getDouble("rating");
                                    String image = productObject.getString("image");

                                    String rate = String.valueOf(rating);
                                    float newRate = Float.valueOf(rate);

                                    ProductA product = new ProductA(id,title,price, newRate,image);
                                    productList.add(product);
                                }
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                            ProductAdapter adapter= new ProductAdapter(ProductAdminActivity.this,productList);
                            recyclerView.setAdapter(adapter);
                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            Toast.makeText(ProductAdminActivity.this, error.getMessage(), Toast.LENGTH_LONG).show();
                        }
                    });
            Volley.newRequestQueue(this).add(stringRequest);
        }
    public void btn_add_activity(View view) {
        Intent intent = new Intent(ProductAdminActivity.this, Add.class);
        startActivity(intent);
    }




}