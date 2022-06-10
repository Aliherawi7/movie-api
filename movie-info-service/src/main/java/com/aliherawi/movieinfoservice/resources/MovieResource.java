package com.aliherawi.movieinfoservice.resources;

import com.aliherawi.movieinfoservice.models.Movie;
import com.aliherawi.movieinfoservice.models.MovieSummary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @Value("${api.key}")
    private String apiKey;
    @Autowired
    private RestTemplate restTemplate;

//    @RequestMapping("/{movieId}")
//    public Movie getMovie(@PathVariable String movieId) {
//
//        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"
//                + movieId + "api_key=" + apiKey, MovieSummary.class);
//        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
//    }
    @RequestMapping("/{movieId}")
    public Movie getMovieInfo(@PathVariable String movieId) {

        return new Movie(movieId, "test name", "description...");
    }

}
