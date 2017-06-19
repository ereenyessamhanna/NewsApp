package com.example.ereenyessam.newsapp;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lenovov on 25-Jan-17.
 */
public class ImageParser implements Parser {
    JSONObject allPage;
    JSONObject user;
    JSONObject urlLogos;
    JSONArray sources;
    String[] imageURLS;

    @Override
    public String[] parse(String JSONCode) throws JSONException {
        allPage = new JSONObject(JSONCode);

        sources = allPage.getJSONArray("sources");
        imageURLS = new String[sources.length()];
        for(int i=0 ; i<sources.length(); i++){
            user = sources.getJSONObject(i);
            urlLogos = user.getJSONObject("urlsToLogos");
            imageURLS[i] = urlLogos.getString("medium");
        }

        return imageURLS;
    }

}
