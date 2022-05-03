package com.example.appwithDB.repository;

import com.example.appwithDB.model.Movie;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;


public interface MovieRepository extends JpaRepository<Movie,Long> {

    Optional<Movie> findByName(String movieName);
}
