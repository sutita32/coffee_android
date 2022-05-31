package com.example.registration.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.registration.R;

public class LogoutAdminActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logout_admin);
    }
    public void openAppLogin(View v) {
        Intent itn = new Intent(this, HomeAdminActivity.class);
        startActivity(itn);
    }
}