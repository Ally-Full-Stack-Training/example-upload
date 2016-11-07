package com.ironyard.movies.repositories;

import com.ironyard.movies.data.Movie;
import org.springframework.data.repository.CrudRepository;

/**
 * Means we will be dealing with 'Movie' objects and their primary
 * key will be of type 'Long' aka long
 * CrudRepository<Movie, Long>
 */
public interface MovieRepository extends CrudRepository<Movie, Long>  {

}
