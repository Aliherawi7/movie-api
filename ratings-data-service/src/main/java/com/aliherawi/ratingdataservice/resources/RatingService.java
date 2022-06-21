package com.aliherawi.ratingdataservice.resources;

import com.aliherawi.ratingdataservice.models.Rating;
import com.aliherawi.ratingdataservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class RatingService {
    @Autowired
    private RatingRepository ratingRepository;

    // get rating by userId
    public UserRating getRatingsByUserId(String userId){
        
        UserRating rating = new UserRating();
        List<Rating> ratingList = ratingRepository.findAllByUserId(userId);
        rating.setUserRating(ratingList);
        System.out.println(rating.getSize());
        return rating;
//        if(rating.getSize()>0){
//            return new ResponseEntity<UserRating>(rating, HttpStatus.OK);
//        }else {
//            return new ResponseEntity<String>
//                    ("This user does not rated any movie", HttpStatus.NOT_FOUND);
//        }
    }
    // save or update rating
    public void addRating(Rating rating) {
        ratingRepository.save(rating);
    }

    // delete rating by userId and movieId
    public void deleteRating(String userId, int movieId){
        ratingRepository.deleteByUserIdAndMovieId(userId, movieId);
    }
}
