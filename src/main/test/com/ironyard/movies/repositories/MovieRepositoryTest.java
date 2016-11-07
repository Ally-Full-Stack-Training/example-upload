package com.ironyard.movies.repositories;


import com.ironyard.movies.data.Actor;
import com.ironyard.movies.data.Movie;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.data.repository.config.RepositoryConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.ArrayList;

import static org.junit.Assert.*;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = {RepositoryConfiguration.class})
public class MovieRepositoryTest {

    private MovieRepository movieRepository;

//    @Autowired
//    public void setMovieRepository(MovieRepository a) {
//        this.movieRepository = a;
//    }

    @Test
    public void testSaveProduct() {
        //setup product
        Movie mov = new Movie();
        mov.setName("Spring Framework Guru Shirt");
        mov.setCat("Magic");
        mov.setSalesAmountMillions(1234);

        Actor tmp = new Actor();
        tmp.setName("Tom Cruise");
        tmp.setAge(29);
        tmp.setRating("A level");
        mov.setActors(new ArrayList<>());
        mov.getActors().add(tmp);

        //save product, verify has ID value after save
        assertTrue(mov.getId() == 0); //null before save
        movieRepository.save(mov);
        assertTrue(mov.getId() > 0); //not null after save

        //fetch from DB
        Movie fetchedMovie = movieRepository.findOne(mov.getId());

        //should not be null
        assertNotNull(fetchedMovie);

        //should equal
        assertEquals(mov.getId(), fetchedMovie.getId());
        assertEquals(mov.getName(), fetchedMovie.getName());

        //update description and save
        fetchedMovie.setName("David Blain");
        movieRepository.save(fetchedMovie);

        //get from DB, should be updated
        Movie fetchedUpdatedMovie = movieRepository.findOne(fetchedMovie.getId());
        assertEquals(fetchedMovie.getName(), fetchedUpdatedMovie.getName());

        //verify count of products in DB
        long productCount = movieRepository.count();
        assertTrue(productCount > 0);

        //get all products, list should only have one
        Iterable<Movie> movies = movieRepository.findAll();

        int count = 0;

        for (Movie p : movies) {
            count++;
        }

        assertTrue(count > 0);
    }
}