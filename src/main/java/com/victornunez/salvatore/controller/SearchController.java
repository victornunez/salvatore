package com.victornunez.salvatore.controller;

import com.victornunez.salvatore.model.movie.SimilarMovie;
import com.victornunez.salvatore.service.search.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class SearchController {
    private static final Integer PAGE = 1;
    private SearchService service;

    @Autowired
    public SearchController(SearchService service) {
        this.service = service;
    }

    @GetMapping(value = "/search")
    public List<SimilarMovie> search(@RequestParam(value = "q") String query, @RequestParam Optional<Integer> page) {
        return service.searchMovies(query, page.orElse(PAGE));
    }
}
