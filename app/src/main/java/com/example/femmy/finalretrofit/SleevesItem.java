package com.example.femmy.finalretrofit;

/**
 * Created by FAMY on 01-Apr-17.
 */

public class SleevesItem {

    String sleeves_name,sleeves_image;

    SleevesItem()
    {

    }

    SleevesItem(String sleeves_name,String sleeves_image)
    {
        this.sleeves_name= sleeves_name;
        this.sleeves_image=sleeves_image;
    }

    public String getSleeves_name() {
        return sleeves_name;
    }

    public void setSleeves_name(String sleeves_name) {
        this.sleeves_name = sleeves_name;
    }

    public String getSleeves_image() {
        return sleeves_image;
    }

    public void setSleeves_image(String sleeves_image) {
        this.sleeves_image = sleeves_image;
    }
}
