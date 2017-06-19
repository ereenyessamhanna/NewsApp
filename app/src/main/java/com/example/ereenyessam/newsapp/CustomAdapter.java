package com.example.ereenyessam.newsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;


public class CustomAdapter extends ArrayAdapter<String>
{
    Context context;
    String[] imageURLS;

    public CustomAdapter(Context context, String[] imageURLS) {
        super(context,R.layout.grid_item,R.id.grid_movieImage,imageURLS);
        this.context = context;
        this.imageURLS = imageURLS;

    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View gridItem = convertView;
        Log.i("position : ", String.valueOf(position));

        if(gridItem == null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            gridItem = inflater.inflate(R.layout.grid_item,parent,false);
        }

        ImageView image = (ImageView) gridItem.findViewById(R.id.grid_movieImage);
        Log.i("ereenyessamhanna",imageURLS[position]);
        Picasso.with(context).load(imageURLS[position]).placeholder(R.mipmap.ic_launcher).into(image);


        return gridItem;
    }
}
