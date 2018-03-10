package com.Alatheer.m.schooles.Models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by ok on 29/01/2018.
 */

public class News_Model {

    private String id;

    private String schoolsId;

    private String newsDate;

    private String newsTitle;

    private String newsContent;

    private String newsVideo;

    private String branchId;

    private String idNews;

    private String schoolId;

    private String schoolName;

    private String imageName;
    private String message;

    public News_Model(String id, String message) {
        this.id = id;
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * No args constructor for use in serialization
     *
     */
    public News_Model() {
    }

    /**
     *
     * @param idNews
     * @param id
     * @param schoolName
     * @param newsVideo
     * @param imageName
     * @param branchId
     * @param newsContent
     * @param newsDate
     * @param schoolId
     * @param newsTitle
     * @param schoolsId
     */
    public News_Model(String id, String schoolsId, String newsDate, String newsTitle, String newsContent, String newsVideo, String branchId, String idNews, String schoolId, String schoolName, String imageName) {
        super();
        this.id = id;
        this.schoolsId = schoolsId;
        this.newsDate = newsDate;
        this.newsTitle = newsTitle;
        this.newsContent = newsContent;
        this.newsVideo = newsVideo;
        this.branchId = branchId;
        this.idNews = idNews;
        this.schoolId = schoolId;
        this.schoolName = schoolName;
        this.imageName = imageName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSchoolsId() {
        return schoolsId;
    }

    public void setSchoolsId(String schoolsId) {
        this.schoolsId = schoolsId;
    }

    public String getNewsDate() {
        return newsDate;
    }

    public void setNewsDate(String newsDate) {
        this.newsDate = newsDate;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    public String getNewsContent() {
        return newsContent;
    }

    public void setNewsContent(String newsContent) {
        this.newsContent = newsContent;
    }

    public String getNewsVideo() {
        return newsVideo;
    }

    public void setNewsVideo(String newsVideo) {
        this.newsVideo = newsVideo;
    }

    public String getBranchId() {
        return branchId;
    }

    public void setBranchId(String branchId) {
        this.branchId = branchId;
    }

    public String getIdNews() {
        return idNews;
    }

    public void setIdNews(String idNews) {
        this.idNews = idNews;
    }

    public String getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(String schoolId) {
        this.schoolId = schoolId;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getImageName() {
        return imageName;
    }

    public void setImageName(String imageName) {
        this.imageName = imageName;
    }



}

