package com.victornunez.salvatore.storage;

import com.victornunez.salvatore.storage.pojo.MovieDAO;
import java.util.List;

public interface CustomMovieListOperations {
    void addMovies(String listId, List<MovieDAO> movies);
    void deleteMovies(String listId, List<String> movieIds);
}
