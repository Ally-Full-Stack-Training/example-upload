package com.ironyard.movies.controler;

import com.ironyard.movies.data.Movie;
import com.ironyard.movies.repositories.MovieRepository;
import io.swagger.annotations.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

/**
 * Created by jasonskipper on 10/10/16.
 */
@RestController
public class MovieController {

    private final Logger log = LoggerFactory.getLogger(this.getClass());
    private MovieRepository movieRepository;

    /**
     * Example of "Dependency Injection" spring is setting this for us
     * @param aRepo
     */
    @Autowired
    public void setMovieRepository(MovieRepository aRepo) {
        this.movieRepository = aRepo;
    }

    /**
     *  produces means what is the MIME Type of data coming back from reqeust
     * @param aMovie
     * @return
     */
    @RequestMapping(value = "/service/movie", method = RequestMethod.POST, produces = "application/json")
    public Movie save(@RequestBody Movie aMovie){
        movieRepository.save(aMovie);
        return movieRepository.findOne(aMovie.getId());
    }

    @RequestMapping(value = "/service/movie/update", method = RequestMethod.PUT)
    public Movie update(@RequestBody Movie aMovie){
            movieRepository.save(aMovie);
           return movieRepository.findOne(aMovie.getId());
    }

    @RequestMapping(value = "/service/movie/{id}", method = RequestMethod.GET)
    public Movie show(@PathVariable Long id){
        return movieRepository.findOne(id);
    }

    @RequestMapping(value = "/service/movies", method = RequestMethod.GET)
    public Iterable<Movie> list(){
        log.debug("Call to list method...");
        Iterable<Movie> list =  movieRepository.findAll();
        log.debug("Fectch Complete:"+list);
        return list;
    }

    @RequestMapping(value = "/service/movie/delete/{id}", method = RequestMethod.DELETE)
    public Movie delete(@PathVariable Long id){
        Movie deleted = movieRepository.findOne(id);
        movieRepository.delete(id);
        return deleted;
    }

    @ExceptionHandler(value = Throwable.class)
    public String nfeHandler(Throwable e){
        return "Something went wrong :/";
    }
}
