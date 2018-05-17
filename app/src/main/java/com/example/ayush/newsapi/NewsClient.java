package com.example.ayush.newsapi;

import com.example.ayush.newsapi.Newss;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;


public interface NewsClient {

    String base_Url = "https://newsapi.org";

    @GET("/v2/top-headlines")
    //@GET("/v2/top-headlines?country=us&category=business&apiKey=9bc5e981dcc1445daa163e365b02d139")
    Call<Newss> getNews(@Query("api_key") String api_key);

}
