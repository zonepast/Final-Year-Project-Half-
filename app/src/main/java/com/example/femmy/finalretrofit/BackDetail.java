
package com.example.femmy.finalretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BackDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("back_pattern_name")
    @Expose
    private String backPatternName;
    @SerializedName("back_pattern_image")
    @Expose
    private String backPatternImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBackPatternName() {
        return backPatternName;
    }

    public void setBackPatternName(String backPatternName) {
        this.backPatternName = backPatternName;
    }

    public String getBackPatternImage() {
        return backPatternImage;
    }

    public void setBackPatternImage(String backPatternImage) {
        this.backPatternImage = backPatternImage;
    }

}
