package com.victornunez.salvatore.controller;

import com.victornunez.salvatore.model.movie.Movie;
import com.victornunez.salvatore.service.movie.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
public class MovieController {
    private MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }

    @GetMapping(value = "/movie/{id}")
    public Optional<Movie> getMovie(@PathVariable String id) {
        return service.getMovie(id);
    }
}