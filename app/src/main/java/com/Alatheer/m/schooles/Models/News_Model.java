package com.Alatheer.m.schooles.Models;

/**
 * Created by ok on 29/01/2018.
 */

public class News_Model {
    String news_title;
    String news_content;
    String image_name;

    public String getimage_name() {
        return image_name;
    }

    public News_Model(String news_title) {
        this.news_title = news_title;
    }

    public void setnews_title(String news_title) {
        this.news_title = news_title;
    }


    public void setimage_name(String image_name) {
        image_name = image_name;
    }

    public News_Model(String news_title, String news_content) {
        this.news_title = news_title;
        this.news_content = news_content;
    }

    public String getnews_title() {

        return news_title;
    }

    public void setnews_content(String news_content) {
        this.news_content = news_content;
    }

    public String getnews_content() {

        return news_content;
    }


}

