package com.victornunez.salvatore.controller;

import com.victornunez.salvatore.model.Movie;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class MovieController {

    @GetMapping(value = "/movie/{id}")
    public Movie getMovie(@PathVariable String id) {
        return new Movie(id);
    }

    @GetMapping(value = "/movie")
    public List<Movie> searchMovie(@RequestParam(value = "q") String query, @RequestParam Optional<Integer> page) {
        return Collections.emptyList();
    }
}