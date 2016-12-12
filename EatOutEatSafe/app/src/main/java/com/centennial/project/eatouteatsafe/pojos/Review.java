package com.centennial.project.eatouteatsafe.pojos;

import java.io.Serializable;

/**
 * Created by Jihee Seo on 11/27/2016.
 */

public class Review implements Serializable {
    public String res_Id;
    public String review_Id;
    public String author_Id;

    private String author_name;
    private String title;
    private String content;
    private float rate;

    public String getAuthor_name() {
        return author_name;
    }

    public String getRes_Id() {
        return res_Id;
    }

    public String getReview_Id() {
        return review_Id;
    }

    public String getAuthor_Id() {
        return author_Id;
    }

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public float getRate() {
        return rate;
    }

    public void setRes_Id(String res_Id) {
        this.res_Id = res_Id;
    }

    public void setReview_Id(String review_Id) {
        this.review_Id = review_Id;
    }

    public void setAuthor_Id(String author_Id) {
        this.author_Id = author_Id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public void setAuthor_name(String author_name) {
        this.author_name = author_name;
    }
}
