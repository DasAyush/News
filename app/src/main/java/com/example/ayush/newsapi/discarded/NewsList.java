package com.example.ayush.newsapi.discarded;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

/**
 * Created by ayush on 28/4/18.
 */

public class NewsList implements Serializable{

    @SerializedName("articles")
    private List<NewsModel> newsModels;

    public List<NewsModel> getNewsModels() {
        return newsModels;
    }

    public void setNewsModels(List<NewsModel> newsModels) {
        this.newsModels = newsModels;
    }
}
