package com.aliherawi.ratingdataservice.models;

import java.util.List;

public class UserRating {

    private List<Rating> userRating;


    public List<Rating> getUserRating() {
        return userRating;
    }
    public void setUserRating(List<Rating> userRating) {
        this.userRating = userRating;
    }
    public int getSize(){
        return this.userRating.size();
    }


}
