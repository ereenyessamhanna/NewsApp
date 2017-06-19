package com.example.ereenyessam.newsapp;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.GridView;


public class ArticlesFragment extends Fragment {
    View rootView;
    Intent intent;
    GridView gridView;
    AsyncTask asyncTask;

    public ArticlesFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = inflater.inflate(R.layout.fragment_articles,container,false);
        gridView = (GridView) rootView.findViewById(R.id.article_grid_view);
        intent = getActivity().getIntent();
        getActivity().setTitle(intent.getStringExtra("name"));
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();

        String url = "https://newsapi.org/v1/articles?source=" + intent.getStringExtra("id") + "&sortBy=" + intent.getStringExtra("sort_by") + "&apiKey=f75e47830bde44fdbb18b4ed5731fb96";

        asyncTask = new AsyncTask(url,new ArticleParser()){
            @Override
            protected void onPostExecute(String[] strings) {
                super.onPostExecute(strings);

                final articleInfo[] articleInfos = new articleInfo[10];
                int counter =0;
                for(int i=0; i<10; i++){
                    articleInfos[i] = new articleInfo();
                    articleInfos[i].setTitle(strings[counter++]);
                    articleInfos[i].setDescription(strings[counter++]);
                    articleInfos[i].setUrl(strings[counter++]);
                    articleInfos[i].setDate(strings[counter++]);
                    articleInfos[i].setUrlToImage(strings[counter++]);


                }

                ArticleAdapter articleAdapter = new ArticleAdapter(getActivity(), articleInfos);
                GridView gridview = (GridView) rootView.findViewById(R.id.article_grid_view);
                gridview.setAdapter(articleAdapter);
                gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(articleInfos[position].getUrl())));

                    }


                });
            }
        };
        asyncTask.execute();
    }
}
