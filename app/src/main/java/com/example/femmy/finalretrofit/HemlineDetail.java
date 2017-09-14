
package com.example.femmy.finalretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class HemlineDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("hemline_pattern_name")
    @Expose
    private String hemlinePatternName;
    @SerializedName("hemline_pattern_image")
    @Expose
    private String hemlinePatternImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getHemlinePatternName() {
        return hemlinePatternName;
    }

    public void setHemlinePatternName(String hemlinePatternName) {
        this.hemlinePatternName = hemlinePatternName;
    }

    public String getHemlinePatternImage() {
        return hemlinePatternImage;
    }

    public void setHemlinePatternImage(String hemlinePatternImage) {
        this.hemlinePatternImage = hemlinePatternImage;
    }

}
