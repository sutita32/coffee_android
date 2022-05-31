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

public class OrderActivity extends AppCompatActivity {
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

            intent = new Intent(OrderActivity.this, HomeActivity.class);
            startActivity(intent);
            Toast.makeText(OrderActivity.this,"Home!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuCart){

            intent = new Intent(OrderActivity.this, CartActivity.class);
            startActivity(intent);
            Toast.makeText(OrderActivity.this,"Cart!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuUser){

            intent = new Intent(OrderActivity.this, AccountActivity.class);
            startActivity(intent);
            Toast.makeText(OrderActivity.this,"Account!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuLogout){

            intent = new Intent(OrderActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(OrderActivity.this,"Logout!",Toast.LENGTH_SHORT).show();
        }

        return true;
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboard_menu,menu);

        return true;
    }

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        mToolbar = findViewById(R.id.dashboard_toolbar);
        progressBar = findViewById(R.id.progressbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();

    }
    public void btn_payment_activity(View view) {
        Intent intent = new Intent(OrderActivity.this, PaymentActivity.class);
        startActivity(intent);
    }


//
//




}