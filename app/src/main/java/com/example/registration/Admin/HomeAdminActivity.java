package com.example.registration.Admin;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.registration.NotificationsActivity;
import com.example.registration.R;
import com.example.registration.SettingsActivity;
import com.example.registration.User.MainActivity;
import com.example.registration.User.Product;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class HomeAdminActivity extends AppCompatActivity {

    // Variable declarations
    private String userEmail;
    private TextView textView;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter mAdapter;
    private List<Product> products;
    private ProgressBar progressBar;
    private static  final String BASE_URL = "http://192.168.1.179/Mobu/getProduct.php";

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        if (item.getItemId() == R.id.Home){

            intent = new Intent(HomeAdminActivity.this, HomeAdminActivity.class);
            startActivity(intent);
            Toast.makeText(HomeAdminActivity.this,"Home!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.Product){

            intent = new Intent(HomeAdminActivity.this, ProductAdminActivity.class);
            startActivity(intent);
            Toast.makeText(HomeAdminActivity.this,"Product!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.User){

            intent = new Intent(HomeAdminActivity.this, AccountAdminActivity.class);
            startActivity(intent);
            Toast.makeText(HomeAdminActivity.this,"Account!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.Logout){

            intent = new Intent(HomeAdminActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(HomeAdminActivity.this,"Log Out!",Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_home_admin);

        mToolbar = findViewById(R.id.dashboard_toolbar);
        progressBar = findViewById(R.id.progressbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();

    }

}