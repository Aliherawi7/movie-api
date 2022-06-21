package com.aliherawi.ratingdataservice.resources;

import com.aliherawi.ratingdataservice.models.Rating;
import com.aliherawi.ratingdataservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {
    @Autowired
    private RatingService ratingService;

    @RequestMapping("/{userId}")
    public UserRating getRating(@PathVariable String userId) {
        return ratingService.getRatingsByUserId(userId);
    }

    @RequestMapping(method= RequestMethod.POST)
    public void addRating(@RequestBody Rating rating){
        ratingService.addRating(rating);
    }


}
