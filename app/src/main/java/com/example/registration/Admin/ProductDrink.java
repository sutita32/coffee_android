package com.example.registration.Admin;

public class ProductDrink {
    private String id,title, image;
    private Double price;
    private float rating;

    public ProductDrink() {
    }

    public ProductDrink(String id, String title, double price, float rating, String image) {
        this.id = id;
        this.title = title;
        this.price = price;
        this.rating = rating;
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

    public void setTitle(String title) {
        this.title = title;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public float getRating() {
        return rating;
    }

    public void setRating(float rating) {
        this.rating = rating;
    }
}



