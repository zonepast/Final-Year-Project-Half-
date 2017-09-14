
package com.example.femmy.finalretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class PatternDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("pattern_image")
    @Expose
    private String patternImage;
    @SerializedName("caption")
    @Expose
    private String caption;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPatternImage() {
        return patternImage;
    }

    public void setPatternImage(String patternImage) {
        this.patternImage = patternImage;
    }

    public String getCaption() {
        return caption;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

}
