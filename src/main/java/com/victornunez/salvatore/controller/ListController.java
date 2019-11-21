package com.victornunez.salvatore.controller;

import com.victornunez.salvatore.model.list.MovieList;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ListController {
    @GetMapping(value = "/list/{id}")
    public MovieList getList(@PathVariable String id) {
        return new MovieList();
    }

    @PostMapping(value = "/list")
    public MovieList createList(@RequestBody String name) {
        return new MovieList();
    }

    @DeleteMapping(value = "/list/{id}")
    public MovieList deleteList(@PathVariable String id) {
        return new MovieList();
    }

    @PostMapping(value = "/list/{id}/movies")
    public MovieList addMoviesToList(@PathVariable String id, @RequestBody List<String> movies) {
        return new MovieList();
    }

    @DeleteMapping(value = "/list/{id}/movies")
    public MovieList deleteMoviesFromList(@PathVariable String id, @RequestBody List<String> movies) {
        return new MovieList();
    }
}
