package com.example.registration.User;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.registration.R;

public class CartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.dashboard_menu,menu);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.menuHome){

            Intent home = new Intent(CartActivity.this, HomeActivity.class);
            startActivity(home);
            return true;
        }
        else if (id == R.id.menuCart){

            Intent cart = new Intent(CartActivity.this, CartActivity.class);
            startActivity(cart);
            return true;
        }
        else if (id == R.id.menuUser){

            Intent user = new Intent(CartActivity.this, AccountActivity.class);
            startActivity(user);
            return true;
        }
        return true;
    }


}