package com.aliherawi.movieinfoservice.resources;

import com.aliherawi.movieinfoservice.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MovieRepository extends CrudRepository<Movie, Integer> {

}
