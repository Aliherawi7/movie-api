package com.aliherawi.moviecatalogservice.resources;

import com.aliherawi.moviecatalogservice.models.CatalogItem;
import com.aliherawi.moviecatalogservice.models.Movie;
import com.aliherawi.moviecatalogservice.models.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {

    @Autowired
    private RestTemplate restTemplate;

    @RequestMapping("/{userId}")
    public List<CatalogItem> getCatalog(@PathVariable String userId) {

        UserRating ratings = restTemplate.getForObject("http://rating-data-service/ratingdata/users/" + userId, UserRating.class);
        return ratings.getUserRating().stream().map(rating -> {

            //for each movie ID call movie info service and get the movie details
            Movie movie = restTemplate.getForObject("http://movie-info-service/movies/" + rating.getMovieId(), Movie.class);
            // put all them together
            return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());

        })
                .collect(Collectors.toList());


    }

}
