package com.example.ereenyessam.newsapp;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;

import org.json.JSONException;

public class MainFragment extends Fragment {
    View rootView;
    GridView gridView;
    AsyncTask imageLoader;

    public MainFragment() {

    }


    @Override
    public View onCreateView(final LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_main, container, false);
        gridView = (GridView) rootView.findViewById(R.id.gridView);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                try {
                    Source_id sid = IdParser.parseID(imageLoader.getJSONCode(), position);
                    Intent intent = new Intent(getContext(),ArticlesActivity.class);
                    Log.v("id",sid.getId());
                    intent.putExtra("id",sid.getId());
                    intent.putExtra("sort_by",sid.getSort());
                    intent.putExtra("name", sid.getName());
                    startActivity(intent);
                } catch (JSONException e) {
                    e.printStackTrace();
                }
               /* Intent intent = new Intent(getContext(),DetailsActivity.class);
                startActivity(intent);*/
            }
        });


        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        //Grid Images
        String mainUrl = "https://newsapi.org/v1/sources?source=abc-news-au&sortBy=latest&apiKey=" + "f75e47830bde44fdbb18b4ed5731fb96";


        imageLoader = new AsyncTask(mainUrl, new ImageParser()) {
            @Override
            protected void onPostExecute(String[] strings) {
                super.onPostExecute(strings);
                Log.v("Urls", strings[0]);
                Log.v("Urls", strings[69]);
                CustomAdapter customAdapter = new CustomAdapter(getActivity(), strings);
                GridView gridview = (GridView) rootView.findViewById(R.id.gridView);
                gridview.setAdapter(customAdapter);

            }
        };
        imageLoader.execute();
    }
}
