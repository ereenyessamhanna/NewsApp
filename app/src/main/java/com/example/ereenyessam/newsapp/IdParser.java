package com.example.ereenyessam.newsapp;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by lenovov on 26-Jan-17.
 */
public class IdParser {

    public static Source_id parseID(String JSONCode , int position) throws JSONException {
        Source_id id = new Source_id();
        JSONObject allPage = new JSONObject(JSONCode);
        JSONArray sources = allPage.getJSONArray("sources");
        JSONObject user = sources.getJSONObject(position);

        id.setName(user.getString("name"));
        id.setId(user.getString("id"));

        JSONArray sort = user.getJSONArray("sortBysAvailable");
        Log.v("name: ", user.getString("name"));
        id.setSort(sort.getString(0));


        return id;
    }
}
