
package com.example.femmy.finalretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class BottomDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("bottom_pattern_name")
    @Expose
    private String bottomPatternName;
    @SerializedName("bottom_pattern_image")
    @Expose
    private String bottomPatternImage;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBottomPatternName() {
        return bottomPatternName;
    }

    public void setBottomPatternName(String bottomPatternName) {
        this.bottomPatternName = bottomPatternName;
    }

    public String getBottomPatternImage() {
        return bottomPatternImage;
    }

    public void setBottomPatternImage(String bottomPatternImage) {
        this.bottomPatternImage = bottomPatternImage;
    }

}
