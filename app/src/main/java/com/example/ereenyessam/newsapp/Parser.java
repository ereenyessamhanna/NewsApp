package com.example.ereenyessam.newsapp;

import org.json.JSONException;

public interface Parser {
    String[] parse(String JSONCode) throws JSONException;

}
