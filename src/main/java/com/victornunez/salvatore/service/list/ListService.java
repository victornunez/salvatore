package com.victornunez.salvatore.service.list;

import com.victornunez.salvatore.model.list.MovieList;
import com.victornunez.salvatore.storage.Lists;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class ListService {
    private Lists lists;

    public ListService(Lists lists) {
        this.lists = lists;
    }

    public MovieList getLists(String id) {
        return lists.getList(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot find list"));
    }

    public MovieList createList(String user, String name) {
        return lists.createList(user, name)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot create list"));
    }

    public MovieList deleteList(String id) {
        return lists.deleteList(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot delete list"));
    }

    public MovieList addMovies(String id, List<String> movies) {
        return lists.addMovies(id, movies)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot add movies"));
    }

    public MovieList removeMovies(String id, List<String> movies) {
        return lists.removeMovies(id, movies)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Cannot delete movies"));
    }
}
