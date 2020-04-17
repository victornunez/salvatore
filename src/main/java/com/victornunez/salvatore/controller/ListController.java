package com.victornunez.salvatore.controller;

import com.victornunez.salvatore.model.list.CreateListInfo;
import com.victornunez.salvatore.model.list.MovieList;
import com.victornunez.salvatore.model.list.MoviesParams;
import com.victornunez.salvatore.service.list.ListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@RestController
public class ListController {
    private ListService service;

    @Autowired
    public ListController(ListService service) {
        this.service = service;
    }

    @GetMapping(value = "/list/{id}")
    public MovieList getList(@PathVariable String id) {
        return service.getLists(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot find list"));
    }

    @PostMapping(value = "/list")
    public MovieList createList(@RequestBody CreateListInfo info) {
        return service.createList(info.getUser(), info.getName())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot create list"));
    }

    @DeleteMapping(value = "/list/{id}")
    public MovieList deleteList(@PathVariable String id) {
        return service.deleteList(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot delete list"));
    }

    @PostMapping(value = "/list/{id}/movies")
    public MovieList addMoviesToList(@PathVariable String id, @RequestBody MoviesParams movies) {
        return service.addMovies(id, movies.getMovies())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot add movies"));
    }

    @DeleteMapping(value = "/list/{id}/movies")
    public MovieList deleteMoviesFromList(@PathVariable String id, @RequestBody MoviesParams movies) {
        return service.removeMovies(id, movies.getMovies())
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot delete movies"));
    }
}
