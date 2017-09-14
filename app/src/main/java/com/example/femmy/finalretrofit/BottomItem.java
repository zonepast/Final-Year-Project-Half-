package com.example.femmy.finalretrofit;

/**
 * Created by FAMY on 02-Apr-17.
 */

public class BottomItem {

    String bottom_name,bottom_image;

    BottomItem()
    {

    }

    BottomItem(String bottom_name,String bottom_image)
    {
        this.bottom_name=bottom_name;
        this.bottom_image=bottom_image;
    }

    public String getBottom_name() {
        return bottom_name;
    }

    public void setBottom_name(String bottom_name) {
        this.bottom_name = bottom_name;
    }

    public String getBottom_image() {
        return bottom_image;
    }

    public void setBottom_image(String bottom_image) {
        this.bottom_image = bottom_image;
    }
}
