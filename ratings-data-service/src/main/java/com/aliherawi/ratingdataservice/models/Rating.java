package com.aliherawi.ratingdataservice.models;

import org.springframework.cglib.reflect.FastClass;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Rating {
    @Id
    @GeneratedValue
    private int ratingId;
    private int movieId;
    private int rating;
    private String userId;

    public Rating() {

    }
    public Rating(int ratingId, int movieId, int rating, String userId) {
        this.ratingId = ratingId;
        this.movieId = movieId;
        this.rating = rating;
        this.userId = userId;
    }
    public int getRatingId(){
        return ratingId;
    }
    public void setRatingId(int ratingId){
        this.ratingId = ratingId;
    }
    public int getMovieId() {
        return movieId;
    }

    public void setMovieId(int movieId) {
        this.movieId = movieId;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getUserId(){
        return  userId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }


}
