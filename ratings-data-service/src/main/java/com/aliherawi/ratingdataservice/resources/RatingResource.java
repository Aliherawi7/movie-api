package com.aliherawi.ratingdataservice.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aliherawi.ratingdataservice.models.Rating;
import com.aliherawi.ratingdataservice.models.UserRating;

@RestController
@RequestMapping("/ratingdata")
public class RatingResource {
	
	@RequestMapping("/{movieId}")
	public Rating getMovie(@PathVariable String movieId) {
		return new Rating(movieId, 4);
	}
	
	@RequestMapping("users/{userId}")
	public UserRating getRating(){
		List<Rating> ratings =  Arrays.asList(
				new Rating("spiderman", 4),
				new Rating("Money heist", 5)
				);
		UserRating userRating = new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}
