package com.example.registration.User;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.registration.R;

public class DetailedProductsActivity extends AppCompatActivity {

    private Double price;
    private Toolbar mToolbar;
    private ActionBar mActionBar;
    private ImageView mImage;
    private TextView mTitle, mRating, mPrice ,mSet;


    @Override
    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed_products);

        mToolbar = findViewById(R.id.toolbar);
        mImage = findViewById(R.id.image_view);
        mPrice = findViewById(R.id.price);
        mRating = findViewById(R.id.rating);
        mTitle = findViewById(R.id.name);

        mSet = findViewById(R.id.quantity );

        // Setting up action bar
        setSupportActionBar(mToolbar);
        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setHomeAsUpIndicator(getResources().getDrawable(R.drawable.ic_back));

        // Catching incoming intent
        Intent intent = getIntent();
        price = intent.getDoubleExtra("price",0);
        int rate = (int) intent.getFloatExtra("rate",0);
        String title = intent.getStringExtra("title");
        String image = intent.getStringExtra("image");

        if (intent !=null){

            mActionBar.setTitle(title);
            mTitle.setText(title);
            mRating.setText("Rating :"+rate+" /2");


            mPrice.setText(String.valueOf("Total price is "+price));

            Glide.with(DetailedProductsActivity.this).load(image).into(mImage);
        }
    }
    public void btn_add_activity(View view) {
        Intent intent = new Intent(DetailedProductsActivity.this, OrderActivity.class);
        startActivity(intent);
    }
    int i = 0;
    double j = 0;
    String string0 =String.valueOf(i);
    public void btn_add(View view) {

        TextView p1 = findViewById(R.id.price);
        j = price + j;
        p1.setText(String.valueOf("Total price is " + j));
        TextView tv1 = findViewById(R.id.quantity );
        i++;
        tv1.setText(String.valueOf(i));

    }
    public void btn_delete(View view) {
        TextView p1 = findViewById(R.id.price);
        j = j - price;
        p1.setText(String.valueOf("Total price is " + j));
        TextView tv1 = findViewById(R.id.quantity );
        i--;
        tv1.setText(String.valueOf(i));


    }
}








