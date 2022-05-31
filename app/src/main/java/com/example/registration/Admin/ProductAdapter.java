package com.example.registration.Admin;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresPermission;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.icu.text.CaseMap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.registration.R;
import com.example.registration.URLs;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private static final String url ="http://192.168.1.179/Mobu/delete.php";
    private static final String urledit ="http://192.168.1.179/Mobu/edit.php";
    private Context mCtx;
    private List<ProductA> productList;

    public ProductAdapter(Context mCtx, List<ProductA> productList) {
        this.mCtx = mCtx;
        this.productList = productList;
    }

    @Override
    public ProductViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mCtx);
        View view = inflater.inflate(R.layout.product_list, null);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, @SuppressLint("RecyclerView") final int position) {
        final ProductA product = productList.get(position);

        //loading the image
        Glide.with(mCtx)
                .load(product.getImage())
                .into(holder.imageView);

        holder.Title.setText(product.getTitle());
        holder.Rating.setText(String.valueOf(product.getRating()));
        holder.Price.setText(String.valueOf(product.getPrice()));

        holder.Delete.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("DELETE PRODUCT");
                builder.setMessage("Confirm to DELETE "+product.getTitle());
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.setPositiveButton("DELETE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        StringRequest stringRequest = new StringRequest(Request.Method.POST, url,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        try {
                                            JSONObject object = new JSONObject(response);
                                            String check = object.getString("status");
                                            if(check.equals("delete")){
                                                Delete(position);
                                                Toast.makeText(mCtx, "Delete Successful", Toast.LENGTH_SHORT).show();
                                            }else{
                                                Toast.makeText(mCtx, response, Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                                Toast.makeText(mCtx, error.getMessage(), Toast.LENGTH_SHORT).show();
                            }
                        }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                HashMap<String, String> deleteParams = new HashMap<>();
                                deleteParams.put("title", product.getTitle());
                                return deleteParams;
                            }
                        };
                        RequestQueue requestQueue = Volley.newRequestQueue(mCtx);
                        requestQueue.add(stringRequest);
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
            }
        });
        holder.Edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
//
                View editLayout = LayoutInflater.from(mCtx).inflate(R.layout.activity_edit,null);
                final EditText Title = editLayout.findViewById(R.id.edt_title);
                final EditText Price = editLayout.findViewById(R.id.edt_price);
                final EditText Rating = editLayout.findViewById(R.id.edt_rating);
                //ImageView ImageView = editLayout.findViewById(R.id.edt_img);
                Title.setText(product.getTitle());
                Price.setText(String.valueOf(product.getPrice()));
                Rating.setText(String.valueOf(product.getRating()));
//                ImageView.setImageBitmap(product.getImage());
                //final String id = id.getId();
                final String title = Title.getText().toString();
                final String price = Price.getText().toString();
                final String rating = Rating.getText().toString();
                final String oldtitle = product.getTitle();
                AlertDialog.Builder builder = new AlertDialog.Builder(mCtx);
                builder.setTitle("Edit "+product.getTitle());
                builder.setView(editLayout);
                builder.setPositiveButton("UPDATE", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        if(title.isEmpty() || price.isEmpty() || rating.isEmpty()){
                            Toast.makeText(mCtx, "Some Feilds Empty", Toast.LENGTH_SHORT).show();
                        }else{
                            StringRequest stringRequest = new StringRequest(Request.Method.POST, urledit
                                    , new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    Toast.makeText(mCtx, response, Toast.LENGTH_SHORT).show();
                                }
                            }, new Response.ErrorListener() {
                                @Override
                                public void onErrorResponse(VolleyError error) {
                                    Toast.makeText(mCtx, error.toString(),Toast.LENGTH_SHORT).show();
                                }
                            }){
                                @Override
                                protected Map<String, String> getParams() throws AuthFailureError{
                                    HashMap<String,String > params = new HashMap<>();
                                    //params.put("id",id);
                                    params.put("title",title);
                                    params.put("price",price);
                                    params.put("rating",rating);
                                    params.put("oldtitle",oldtitle);
                                    Log.i("Map ", "getParams: "+title+price+rating+oldtitle);
                                    return params;
                                }
                            };
                            RequestQueue queue = Volley.newRequestQueue(mCtx);
                            queue.add(stringRequest);
                        }
                    }
                });
                builder.setNegativeButton("CANCEL", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                AlertDialog dialog = builder.create();
                dialog.show();
                }
        });
    }
    @Override
    public int getItemCount() {
        return productList.size();
    }
    class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView Title, Price, Rating;
        ImageView imageView;
        ImageView Edit,Delete;
        public ProductViewHolder(View itemView) {
            super(itemView);
            Title = itemView.findViewById(R.id.rcy_title);
            Rating = itemView.findViewById(R.id.rcy_rating);
            Price = itemView.findViewById(R.id.rcy_price);
            imageView = itemView.findViewById(R.id.imageView);
            Edit = itemView.findViewById(R.id.rcy_edit);
            Delete = itemView.findViewById(R.id.imgDelete);
        }
    }
    public void Delete(int item){
        productList.remove(item);
        notifyItemRemoved(item);
    }
}
