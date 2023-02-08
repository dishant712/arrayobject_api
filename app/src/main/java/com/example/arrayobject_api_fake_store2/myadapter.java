package com.example.arrayobject_api_fake_store2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.Response;

import java.util.ArrayList;

public class myadapter extends RecyclerView.Adapter<myadapter.myclass> {

    Response.Listener<String> stringListener;
    ArrayList idList,titleList,descList,priceList,disperList,ratingList,stockList,brandList,categoryList;
    public myadapter(Response.Listener<String> stringListener, ArrayList idList, ArrayList titleList, ArrayList descList, ArrayList priceList, ArrayList disperList, ArrayList ratingList, ArrayList stockList, ArrayList brandList, ArrayList categoryList) {

            this.idList=idList;
            this.titleList=titleList;
            this.descList=descList;
            this.priceList=priceList;
            this.disperList=disperList;
            this.ratingList=ratingList;
            this.stockList=stockList;
            this.brandList=brandList;
            this.categoryList=categoryList;

    }

    @NonNull
    @Override
    public myclass onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item,parent,false);
        myclass m =new myclass(view);

        return m;
    }

        class myclass extends RecyclerView.ViewHolder {

        TextView id,title,des,price,disper,rating,stock,brand,category;
            public myclass(@NonNull View itemView) {
                super(itemView);

                id=itemView.findViewById(R.id.item_id);
                title=itemView.findViewById(R.id.item_title);
                des=itemView.findViewById(R.id.item_desc);
                price=itemView.findViewById(R.id.item_price);
                disper=itemView.findViewById(R.id.item_disprice);
                rating=itemView.findViewById(R.id.item_rating);
                stock=itemView.findViewById(R.id.item_stock);
                brand=itemView.findViewById(R.id.item_brand);
                category=itemView.findViewById(R.id.item_category);
            }
        }

    @Override
    public void onBindViewHolder(@NonNull myclass holder, int position) {
            holder.id.setText("Id = "+idList.get(position));
            holder.title.setText("Title = "+titleList.get(position));
            holder.des.setText("Description = "+descList.get(position));
            holder.price.setText("Price = "+priceList.get(position));
            holder.disper.setText("Discount Percentage = "+disperList.get(position));
            holder.rating.setText("Rating = "+ratingList.get(position));
            holder.stock.setText("Stock = "+stockList.get(position));
            holder.brand.setText("Brand = "+brandList.get(position));
            holder.category.setText("Category = "+categoryList.get(position)+"\n");

    }

    @Override
    public int getItemCount() {
        return idList.size();
    }
}
