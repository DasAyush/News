package com.example.ayush.newsapi.discarded;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class NewsModel implements Serializable {

    @SerializedName("author")
    @Expose
    private int author;

    @SerializedName("title")
    @Expose
    private String title;

    /*@SerializedName("user")
    @Expose
    private NewsSourceModel userModel;
    */

    @SerializedName("urlToImage")
    @Expose
    private String urlToImage;

    @SerializedName("description")
    @Expose
    private String description;

    @SerializedName("published_at")
    @Expose
    private String published_at;


    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPublished_at() {
        return published_at;
    }

    public void setPublished_at(String published_at) {
        this.published_at = published_at;
    }

    /*public NewsSourceModel getUserModel() {
        return userModel;
    }

    public void setUserModel(NewsSourceModel userModel) {
        this.userModel = userModel;
    }
    */

    public String getUrlToImage() {
        return urlToImage;
    }

    public void setUrlToImage(String urlToImage) {
        this.urlToImage = urlToImage;
    }
}
