package com.example.ereenyessam.newsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lenovov on 26-Jan-17.
 */
public class ArticleParser implements Parser {
    JSONObject allPage;
    JSONArray articles;
    JSONObject user;
    String[] data;

    @Override
    public String[] parse(String JSONCode) throws JSONException {
        allPage = new JSONObject(JSONCode);
        articles = allPage.getJSONArray("articles");
        data = new String[articles.length()*5];

        int counter = 0;
        for(int i=0; i<articles.length(); i++){
            user = articles.getJSONObject(i);
            data[counter] = user.getString("title");
            Log.i("title: ", data[counter]);
            counter++;

            data[counter] = user.getString("description");
            Log.i("description: ", data[counter]);
            counter++;

            data[counter] = user.getString("url");
            Log.i("url: ", data[counter]);
            counter++;

            data[counter] = user.getString("publishedAt");
            Log.i("publishedAt: ", data[counter]);
            counter++;

            data[counter] = user.getString("urlToImage");
            Log.i("urlToImage: ", data[counter]);
            counter++;




        }




        return data;
    }
}
