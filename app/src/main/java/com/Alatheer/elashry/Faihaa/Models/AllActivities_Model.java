package com.Alatheer.elashry.Faihaa.Models;

/**
 * Created by m on 3/5/2018.
 */

public class AllActivities_Model {
    private String activity_title;
    private String activity_content;
    private String activity_date;
    private String image_name;
    private String message;
    public AllActivities_Model(String activity_title, String activity_content, String activity_date, String image_name) {
        this.activity_title = activity_title;
        this.activity_content = activity_content;
        this.activity_date = activity_date;
        this.image_name = image_name;
    }

    public String getMessage() {
        return message;
    }

    public AllActivities_Model(String message) {
        this.message = message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getActivity_title() {
        return activity_title;
    }

    public void setActivity_title(String activity_title) {
        this.activity_title = activity_title;
    }

    public String getActivity_content() {
        return activity_content;
    }

    public void setActivity_content(String activity_content) {
        this.activity_content = activity_content;
    }

    public String getActivity_date() {
        return activity_date;
    }

    public void setActivity_date(String activity_date) {
        this.activity_date = activity_date;
    }

    public String getImage_name() {
        return image_name;
    }

    public void setImage_name(String image_name) {
        this.image_name = image_name;
    }
}
