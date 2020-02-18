package com.victornunez.salvatore.model.list;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class MoviesParams {
    @JsonProperty private List<String> movies;

    public List<String> getMovies() {
        return movies;
    }
}
