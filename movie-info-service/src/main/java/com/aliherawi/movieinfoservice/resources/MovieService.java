package com.aliherawi.movieinfoservice.resources;

import com.aliherawi.movieinfoservice.models.Movie;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;


@Service
public class MovieService {

    private MovieRepository movieRepository;

    public Movie getMovie(int id){
        return movieRepository.findById(id).get();
    }

    public List<Movie> getAllMovies(){
        List<Movie> Movies = new ArrayList<>();
        movieRepository.findAll()
                .forEach(Movies::add);
        return Movies;
    }

    public void addMovie(Movie movie){
        movieRepository.save(movie);
    }
    public void addAllMovies(List<Movie> movies){
        movieRepository.saveAll(movies);
    }

    public void deleteMovie(int id){
        movieRepository.deleteById(id);
    }
    public void deleteAll(){
        movieRepository.deleteAll();
    }
}
