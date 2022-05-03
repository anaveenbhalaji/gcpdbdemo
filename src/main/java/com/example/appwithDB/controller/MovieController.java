package com.example.appwithDB.controller;

import com.example.appwithDB.model.Movie;
import com.example.appwithDB.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @Autowired
    private MovieService movieService;

    @GetMapping(value ="/")
    public List<Movie> getAllMovies() {return movieService.findAll();}

    @GetMapping(value = "/byName/{movieName}")
    public Optional<Movie> getMovieByName(@PathVariable("movieName") String movieName) {
        return movieService.findByName(movieName);
    }

    @PostMapping(value = "/save")
    public ResponseEntity<?> saveOrUpdateMovie(@RequestBody Movie movie){
        movieService.save(movie);
        return new ResponseEntity("Movie added successfully", HttpStatus.OK);
    }

}
