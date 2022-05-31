package com.example.registration.Admin;

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
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.example.registration.R;
import com.example.registration.SharedPrefManager;
import com.example.registration.User.MainActivity;
import com.example.registration.User.Product;

import java.util.List;

public class AccountAdminActivity extends AppCompatActivity {

    private TextView textViewUsername, textViewUserEmail;
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

        if (item.getItemId() == R.id.Home){

            intent = new Intent(AccountAdminActivity.this, HomeAdminActivity.class);
            startActivity(intent);
            Toast.makeText(AccountAdminActivity.this,"Home!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.Product){

            intent = new Intent(AccountAdminActivity.this, ProductAdminActivity.class);
            startActivity(intent);
            Toast.makeText(AccountAdminActivity.this,"Product!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.User){

            intent = new Intent(AccountAdminActivity.this, AccountAdminActivity.class);
            startActivity(intent);
            Toast.makeText(AccountAdminActivity.this,"Account!",Toast.LENGTH_SHORT).show();
        }
        else if (item.getItemId() == R.id.Logout){

            intent = new Intent(AccountAdminActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(AccountAdminActivity.this,"Log Out!",Toast.LENGTH_SHORT).show();
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
        setContentView(R.layout.activity_account_admin);

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