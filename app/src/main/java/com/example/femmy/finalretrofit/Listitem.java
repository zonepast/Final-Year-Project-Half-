package com.example.femmy.finalretrofit;

/**
 * Created by FAMY on 26-Feb-17.
 */


//MODEL (to get the actual data for the list we create model)

public class Listitem {

    public String heading;
    public String prices;

    public String name, image, price, pattern, quantity;

    public String front_patterns;
    public String images;

    public Listitem() {

    }

   /* public Listitem(String heading, String prices) {
        this.heading = heading;
        this.prices = prices;
    }*/


  /*  public Listitem(String front_patterns, String images) {
        this.images= images;
        this.front_patterns = front_patterns;

    }
*/

    public String getHeading() {
        return heading;
    }

    public String getPrices() {
        return prices;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getPattern() {
        return pattern;
    }

    public void setPattern(String pattern) {
        this.pattern = pattern;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

   /* public String getFront_patterns() {
        return front_patterns;
    }

    public void setFront_patterns(String front_patterns) {
        this.front_patterns = front_patterns;
    }

    public String getImages() {
        return images;
    }

    public void setImages(String images) {
        this.images = images;
    }*/
}
