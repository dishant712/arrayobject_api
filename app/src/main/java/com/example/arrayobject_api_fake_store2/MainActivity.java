package com.example.arrayobject_api_fake_store2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList idList = new ArrayList();
    ArrayList titleList = new ArrayList();
    ArrayList descList = new ArrayList();
    ArrayList priceList = new ArrayList();
    ArrayList disperList = new ArrayList();
    ArrayList ratingList = new ArrayList();
    ArrayList stockList = new ArrayList();
    ArrayList brandList = new ArrayList();
    ArrayList categoryList = new ArrayList();
    RecyclerView recyclerView;
    ProgressDialog  dialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView=findViewById(R.id.recyle);

        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://dummyjson.com/products/category/smartphones";
        dialog= ProgressDialog.show(this,"Please Wait","Data Loading");

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        dialog.dismiss();
                        // Display the first 500 characters of the response string.
                        try {

                            JSONObject jsonObject=new JSONObject(response);
                            JSONArray jsonArray=jsonObject.optJSONArray("products");
                            int total=jsonObject.getInt("total");
                            int limit=jsonObject.getInt("limit");

                            for(int i = 0; i<jsonArray.length();i++)
                            {
                                JSONObject object= jsonArray.getJSONObject(i);
                                idList.add(object.getInt("id"));
                                titleList.add(object.getString("title"));
                                descList.add(object.getString("description"));
                                priceList.add(object.getInt("price"));
                                disperList.add(object.getString("discountPercentage"));
                                ratingList.add(object.getString("rating"));
                                stockList.add(object.getInt("stock"));
                                brandList.add(object.getString("brand"));
                                categoryList.add(object.getString("category"));
                            }

                            myadapter my = new myadapter(this,idList,titleList,descList,priceList,disperList,ratingList,stockList,brandList,categoryList);
                            recyclerView.setAdapter(my);

                            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(null,RecyclerView.VERTICAL,false);
                            recyclerView.setLayoutManager(linearLayoutManager);

                        } catch (JSONException e) {
                            throw new RuntimeException(e);
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        });

// Add the request to the RequestQueue.
        queue.add(stringRequest);

    }
}