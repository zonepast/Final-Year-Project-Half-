
package com.example.femmy.finalretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SleeveDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("sleeve_pattern_name")
    @Expose
    private String sleevePatternName;
    @SerializedName("sleeve_pattern_image")
    @Expose
    private String sleevePatternImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSleevePatternName() {
        return sleevePatternName;
    }

    public void setSleevePatternName(String sleevePatternName) {
        this.sleevePatternName = sleevePatternName;
    }

    public String getSleevePatternImage() {
        return sleevePatternImage;
    }

    public void setSleevePatternImage(String sleevePatternImage) {
        this.sleevePatternImage = sleevePatternImage;
    }

}
