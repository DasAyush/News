package com.example.ayush.newsapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import com.example.ayush.newsapi.Newss;
import com.google.gson.Gson;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    //private Context mContext;

    RecyclerView recNewsView;

    private NewsRecViewAdapter adapter;
    private Newss newsList;

    String apiKey = "9bc5e981dcc1445daa163e365b02d139";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        recNewsView = (RecyclerView)findViewById(R.id.rv_news);

        newsList = new Newss();

        adapter = new NewsRecViewAdapter(this,newsList.getArticles());
        setUpRecyclerView();

        getNews();

    }

    private void setUpRecyclerView() {
        recNewsView.setHasFixedSize(true);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recNewsView.setLayoutManager(layoutManager);
        recNewsView.setAdapter(adapter);
    }

    private void getNews(){

        Retrofit retrofit = new Retrofit.Builder().baseUrl
                (NewsClient.base_Url).addConverterFactory
                (GsonConverterFactory.create())
                .build();

        NewsClient newsClient = retrofit.create(NewsClient.class);
        Call<Newss> call = newsClient.getNews(apiKey);
        call.enqueue(new Callback<Newss>() {
            @Override
            public void onResponse(Call<Newss> call, Response<Newss> response) {
                Log.d("response", new Gson().toJson(response));
                Newss tempNewss = response.body();
                if (tempNewss != null) {
                    newsList.getArticles().addAll(tempNewss.getArticles());
                    //newsList.getArticles().addAll(response.body().getArticles());
                    adapter.setData(tempNewss.getArticles());
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<Newss> call, Throwable t) {
                Log.e("Error in News Client", t.getMessage());
            }
        });

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

