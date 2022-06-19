package com.aliherawi.movieinfoservice.resources;

import com.aliherawi.movieinfoservice.models.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
public class MovieService {
    @Autowired
    private MovieRepository movieRepository;

    public ResponseEntity<?> getMovie(int id){
        Optional<Movie> movie = movieRepository.findById(id);
        if(movie.isPresent()){
            return new ResponseEntity<Movie>(movie.get(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("movie not found!",HttpStatus.NOT_FOUND);
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
    public void deleteAllMovies(){
        movieRepository.deleteAll();
    }
}
