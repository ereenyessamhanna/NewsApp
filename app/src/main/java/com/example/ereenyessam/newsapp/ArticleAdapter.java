package com.example.ereenyessam.newsapp;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

/**
 * Created by lenovov on 26-Jan-17.
 */
public class ArticleAdapter extends ArrayAdapter<articleInfo>
{
        Context context;
        articleInfo[] data;

        public ArticleAdapter(Context context, articleInfo[] data) {
        super(context,R.layout.article_grid_item, data);
        this.context = context;
        this.data = data;

    }


        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            View gridItem = convertView;

                 Log.i("position : ", String.valueOf(position));
                 if (gridItem == null) {
                     LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                     gridItem = inflater.inflate(R.layout.article_grid_item, parent, false);
                 }



                 TextView title = (TextView) gridItem.findViewById(R.id.title);
                 title.setText(data[position].getTitle());

                 TextView description = (TextView) gridItem.findViewById(R.id.description);
                 description.setText(data[position].getDescription());


                 TextView date = (TextView) gridItem.findViewById(R.id.date);
                 date.setText(data[position].getDate());

                 ImageView image = (ImageView) gridItem.findViewById(R.id.image);
                 Picasso.with(context).load(data[position].getUrlToImage()).placeholder(R.mipmap.ic_launcher).into(image);
                 image.getLayoutParams().height = 200;
                 image.getLayoutParams().width = 150;
                 image.requestLayout();


        return gridItem;
    }
}

