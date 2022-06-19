package com.aliherawi.movieinfoservice.resources;

import com.aliherawi.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/movies")
public class MovieResource {
    @Value("${api.key}")
    private String apiKey;
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private MovieService movieService;

//    @RequestMapping("/{movieId}")
//    public Movie getMovie(@PathVariable String movieId) {
//        // getting the movies information from the (Movie DB api)
//        MovieSummary movieSummary = restTemplate.getForObject("https://api.themoviedb.org/3/movie/"
//                + movieId + "api_key=" + apiKey, MovieSummary.class);
//        return new Movie(movieId, movieSummary.getTitle(), movieSummary.getOverview());
//    }



    @RequestMapping("/{movieId}")
    public ResponseEntity<?> getMovieInfo(@PathVariable int movieId) {
        return movieService.getMovie(movieId);
        //return new Movie(1, "spider 1", "....");
    }

    @RequestMapping("/allMovies")
    public List<Movie> getAllMovies(){
       return movieService.getAllMovies();
    }

    @RequestMapping(method = RequestMethod.POST, value = "/movie")
    public void saveMovie(@RequestBody Movie movie){
        movieService.addMovie(movie);
    }

    @RequestMapping(method = RequestMethod.POST)
    public void saveAllMovies(@RequestBody List<Movie> movies){
        movieService.addAllMovies(movies);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/{movieId}")
    public void deleteMovie(@PathVariable int movieId){
        movieService.deleteMovie(movieId);
    }
    @RequestMapping(method = RequestMethod.DELETE)
    public void deleteAllMovies(){
        movieService.deleteAllMovies();
    }

}
