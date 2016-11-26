package com.centennial.project.eatouteatsafe.pojos;

import java.io.Serializable;
import java.util.Comparator;

/**
 * Created by a_b on 11-10-2016.
 */
public class Restaurant implements Serializable{

    public String _id;
    private String name;
    private String ManagerName;
    private String imageURL;
    private String descritpion;
    private String restaurantCategory;
    private Float rating;
    private int reviews;
    private String allergy;
    private String location;
    private  String province;
    private String[] images;
    private boolean isGroupHeader = false;



    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageURL() {
        return imageURL;
    }

    public void setImageURL(String imageURL) {
        this.imageURL = imageURL;
    }

    public String getDescritpion() {
        return descritpion;
    }

    public void setDescritpion(String descritpion) {
        this.descritpion = descritpion;
    }

    public Float getRating() {
        return rating;
    }

    public void setRating(Float rating) {
        this.rating = rating;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getAllergy() {
        return allergy;
    }

    public void setAllergy(String allergy) {
        this.allergy = allergy;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public boolean isGroupHeader() {return isGroupHeader;}

    public void setGroupHeader(boolean groupHeader) {isGroupHeader = groupHeader;}

    public static Comparator<Restaurant> allergyComparator = new Comparator<Restaurant>() {

        public int compare(Restaurant r1, Restaurant r2) {
            String restaurantName1 = r1.getAllergy().toUpperCase();
            String restaurantName2 = r2.getAllergy().toUpperCase();

            //ascending order
            return restaurantName1.compareTo(restaurantName2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
    }};

    public static Comparator<Restaurant> locationComparator = new Comparator<Restaurant>() {

        public int compare(Restaurant r1, Restaurant r2) {
            String restaurantName1 = r1.getLocation().toUpperCase();
            String restaurantName2 = r2.getLocation().toUpperCase();

            //ascending order
            return restaurantName1.compareTo(restaurantName2);

            //descending order
            //return StudentName2.compareTo(StudentName1);
    }};


    public String getManagerName() {
        return ManagerName;
    }

    public void setManagerName(String managerName) {
        ManagerName = managerName;
    }

    public String getRestaurantCategory() {
        return restaurantCategory;
    }

    public void setRestaurantCategory(String restaurantCategory) {
        this.restaurantCategory = restaurantCategory;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String[] getImages() {
        return images;
    }

    public void setImages(String[] images) {
        this.images = images;
    }
}
