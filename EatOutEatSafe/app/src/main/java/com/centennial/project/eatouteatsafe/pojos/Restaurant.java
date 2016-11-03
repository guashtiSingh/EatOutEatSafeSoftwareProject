package com.centennial.project.eatouteatsafe.pojos;

import java.util.Comparator;

/**
 * Created by a_b on 11-10-2016.
 */
public class Restaurant {

    public String _id;
    private String name;
    private String imageURL;
    private String descritpion;
    private Float rating;
    private int reviews;
    private String allergy;
    private String location;


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

}
