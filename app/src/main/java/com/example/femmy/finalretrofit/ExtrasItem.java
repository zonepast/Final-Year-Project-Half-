package com.example.femmy.finalretrofit;

/**
 * Created by FAMY on 03-Apr-17.
 */

public class ExtrasItem {

    String extras_name,extras_price,extras_image;

    ExtrasItem(String extras_name,String extras_price,String extras_image)
    {
        this.extras_name=extras_name;
        this.extras_price=extras_price;
        this.extras_image=extras_image;
    }

    ExtrasItem()
    {

    }

    public String getExtras_price() {
        return extras_price;
    }

    public void setExtras_price(String extras_price) {
        this.extras_price = extras_price;
    }

    public String getExtras_name() {
        return extras_name;
    }

    public void setExtras_name(String extras_name) {
        this.extras_name = extras_name;
    }

    public String getExtras_image() {
        return extras_image;
    }

    public void setExtras_image(String extras_image) {
        this.extras_image = extras_image;
    }
}
