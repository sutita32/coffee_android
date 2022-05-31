package com.example.registration.User;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.registration.Admin.LoginAdminActivity;
import com.example.registration.R;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void openAppInfo(View v) {
        Intent itn = new Intent(this, LoginActivity.class);
        startActivity(itn);
    }

    public void openAppInfoAdmin(View v) {
        Intent itn = new Intent(this, LoginAdminActivity.class);
        startActivity(itn);
    }

}
