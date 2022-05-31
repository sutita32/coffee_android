package com.example.registration.Admin;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.registration.R;

public class Edit extends AppCompatActivity {
    EditText edTitle, edPrice, edRating;
    String Title, Price, Rating, Img;
    ImageView edImage;
    Button btnUpdate;
    ProgressDialog progressDialog;
    private static final String url = "http://192.168.1.179/Mobu/edit.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
//        edTitle = findViewById(R.id.editt1);
//        edPrice = findViewById(R.id.editt2);
//        edRating = findViewById(R.id.editt3);
//        edImage = findViewById(R.id.editimg);
//        btnUpdate = findViewById(R.id.btnUpdate);
//        progressDialog = new ProgressDialog(this);
//
//        getDataIntent();
//        btnUpdate.setOnClickListener((new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                progressDialog.setMessage("Product Data..");
//                progressDialog.setCancelMessage(false);
//                progressDialog.show();
//
//                Title = edTitle.getText().toString();
//                Price = edPrice.getText().toString();
//                Rating = edRating.getText().toString();
//                //Img = edImage.get
//                new Handler().postDelayed(this, 1000);
//
//
//
//            }
//        }));
//    }
//
//    void getDataIntent(){
//        Bundle bundle = getIntent().getExtras();
//        if (bundle!=null){
//            edTitle.setText(bundle.getString("title"));
//            edPrice.setText(bundle.getString("price"));
//            edRating.setText(bundle.getString("rating"));
//        }else{
//            edTitle.setText("");
//            edPrice.setText("");
//            edRating.setText("");
//        }
//    }
//    void validasData(){
//        if(Title.equals("") || Price.equals("") || Rating.equals("")){
//            progressDialog.dismiss();
//            Toast.makeText(Edit.this, "Product Update", Toast.LENGTH_SHORT).show();
//        }else{
//            updateData;
//        }
//    }
//    void updateData(){
//        AndroidNetworking.post("")
//    }
    }
}