package com.example.registration.Admin;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.example.registration.R;

import java.util.List;

public class MyAdapter extends ArrayAdapter<ProductDrink> {

    Context context;
    List<ProductDrink> arrayListProductDrink;


    public MyAdapter(@NonNull Context context, List<ProductDrink> arrayListProductDrink) {
        super(context, R.layout.custom_list_item,arrayListProductDrink);

        this.context = context;
        this.arrayListProductDrink = arrayListProductDrink;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.custom_list_item,null,true);

        TextView tvID = view.findViewById(R.id.txt_id);
        TextView tvTitle = view.findViewById(R.id.txt_title);
        tvID.setText(arrayListProductDrink.get(position).getId());
        tvTitle.setText(arrayListProductDrink.get(position).getTitle());

        return view;
    }
}