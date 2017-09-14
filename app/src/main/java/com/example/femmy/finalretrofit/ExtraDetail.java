
package com.example.femmy.finalretrofit;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ExtraDetail {

    @SerializedName("id")
    @Expose
    private String id;
    @SerializedName("other_pattern_name")
    @Expose
    private String otherPatternName;
    @SerializedName("other_pattern_image")
    @Expose
    private String otherPatternImage;
    @SerializedName("extras_price")
    @Expose
    private String extrasPrice;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOtherPatternName() {
        return otherPatternName;
    }

    public void setOtherPatternName(String otherPatternName) {
        this.otherPatternName = otherPatternName;
    }

    public String getOtherPatternImage() {
        return otherPatternImage;
    }

    public void setOtherPatternImage(String otherPatternImage) {
        this.otherPatternImage = otherPatternImage;
    }

    public String getExtrasPrice() {
        return extrasPrice;
    }

    public void setExtrasPrice(String extrasPrice) {
        this.extrasPrice = extrasPrice;
    }


}
