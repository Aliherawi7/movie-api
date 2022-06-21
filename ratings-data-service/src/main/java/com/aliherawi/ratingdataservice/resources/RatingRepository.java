package com.aliherawi.ratingdataservice.resources;

import com.aliherawi.ratingdataservice.models.Rating;
import com.aliherawi.ratingdataservice.models.UserRating;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface RatingRepository extends CrudRepository<Rating, Integer>{
    List<Rating> findAllByUserId(String userId);
    void deleteByUserIdAndMovieId(String userId, int movieId);
}
