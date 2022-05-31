package com.example.registration.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.registration.R;

public class ProductA {
    private String id,title, image;
    private double price;
    private float rating;

    public ProductA(String id,String title, double price, float rating, String image) {
        this.id = id;
        this.title = title;
        this.rating = rating;
        this.price = price;
        this.image = image;
    }
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public double getRating() {
        return rating;
    }

    public double getPrice() {
        return price;
    }

    public String getImage() {
        return image;
    }
}