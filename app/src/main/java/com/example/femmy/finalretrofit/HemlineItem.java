package com.example.femmy.finalretrofit;

/**
 * Created by FAMY on 02-Apr-17.
 */

public class HemlineItem  {

    String hemline_name,hemline_image;

    HemlineItem()
    {

    }

    HemlineItem(String hemline_name,String hemline_image)
    {
        this.hemline_name=hemline_name;
        this.hemline_image=hemline_image;
    }

    public String getHemline_name() {
        return hemline_name;
    }

    public void setHemline_name(String hemline_name) {
        this.hemline_name = hemline_name;
    }

    public String getHemline_image() {
        return hemline_image;
    }

    public void setHemline_image(String hemline_image) {
        this.hemline_image = hemline_image;
    }
}
