package com.example.registration.User;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registration.R;
import com.example.registration.SharedPrefManager;

import java.util.ArrayList;
import java.util.List;

public class AccountActivity extends AppCompatActivity {
    private String userEmail;
    private TextView textView;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager manager;
    private RecyclerView.Adapter mAdapter;
    private List<Product> products;
    private ProgressBar progressBar;

    private TextView textViewUsername, textViewUserEmail;
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        Intent intent;

        if (item.getItemId() == R.id.menuHome){

            intent = new Intent(AccountActivity.this, HomeActivity.class);
            startActivity(intent);
            Toast.makeText(AccountActivity.this,"Home!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuCart){

            intent = new Intent(AccountActivity.this, CartActivity.class);
            startActivity(intent);
            Toast.makeText(AccountActivity.this,"Cart!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuUser){

            intent = new Intent(AccountActivity.this, AccountActivity.class);
            startActivity(intent);
            Toast.makeText(AccountActivity.this,"Account!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.menuLogout){

            intent = new Intent(AccountActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(AccountActivity.this,"Logout!",Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_account);
        textViewUsername = (TextView) findViewById(R.id.textViewUsername);
        textViewUserEmail = (TextView) findViewById(R.id.textViewUserEmail);

        textViewUserEmail.setText(SharedPrefManager.getInstance(this).getUserEmail());
        textViewUsername.setText(SharedPrefManager.getInstance(this).getUsername());

        mToolbar = findViewById(R.id.dashboard_toolbar);
        progressBar = findViewById(R.id.progressbar);
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();

    }
}