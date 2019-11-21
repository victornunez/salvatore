package com.victornunez.salvatore.controller;

import com.victornunez.salvatore.model.movie.Movie;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {

    @GetMapping(value = "/search")
    public List<Movie> search(@RequestParam(value = "q") String query, @RequestParam Optional<Integer> page) {
        return Collections.emptyList();
    }
}
