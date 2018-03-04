package com.Alatheer.m.schooles.Models;

/**
 * Created by ok on 29/01/2018.
 */

public class News_Model {
    String title;
    String desc;
    String Img;

    public String getImg() {
        return Img;
    }

    public News_Model(String title) {
        this.title = title;
    }

    public void setTitle(String title) {
        this.title = title;
    }


    public void setImg(String img) {
        Img = img;
    }

    public News_Model(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {

        return title;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getDesc() {

        return desc;
    }


}

