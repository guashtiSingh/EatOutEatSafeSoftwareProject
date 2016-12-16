package com.centennial.project.eatouteatsafe.pojos;

/**
 * Created by a_b on 15-12-2016.
 */

public class Menu {
    private String Name;
    private String description;
    private String imageURL;
    private String price;

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
