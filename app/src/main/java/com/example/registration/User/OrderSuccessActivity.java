package com.example.registration.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
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

import com.example.registration.R;

import java.util.List;

public class OrderSuccessActivity extends AppCompatActivity {
    private String userEmail;
    private TextView textView;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter mAdapter;
    private List<Product> products;
    private ProgressBar progressBar;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        if (item.getItemId() == R.id.menuHome){

            intent = new Intent(OrderSuccessActivity.this, HomeActivity.class);
            startActivity(intent);
            Toast.makeText(OrderSuccessActivity.this,"Home!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuCart){

            intent = new Intent(OrderSuccessActivity.this, CartActivity.class);
            startActivity(intent);
            Toast.makeText(OrderSuccessActivity.this,"Cart!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuUser){

            intent = new Intent(OrderSuccessActivity.this, AccountActivity.class);
            startActivity(intent);
            Toast.makeText(OrderSuccessActivity.this,"Account!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuLogout){

            intent = new Intent(OrderSuccessActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(OrderSuccessActivity.this,"Logout!",Toast.LENGTH_SHORT).show();
        }

        return true;
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboard_menu,menu);

        return true;
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_success);
        mToolbar = findViewById(R.id.dashboard_toolbar);
        progressBar = findViewById(R.id.progressbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
    }
    public void btn_sucess_activity(View view) {
        Intent intent = new Intent(OrderSuccessActivity.this, HomeActivity.class);
        startActivity(intent);
    }
}