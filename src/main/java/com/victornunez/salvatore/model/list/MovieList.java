package com.victornunez.salvatore.model.list;

import com.victornunez.salvatore.model.movie.SimilarMovie;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import static org.hibernate.validator.internal.util.CollectionHelper.newHashSet;

public class MovieList {
    private String id;
    private String user;
    private String name;
    private List<SimilarMovie> movies;
    private LocalDate creationDate;

    public MovieList(String id, String user, String name, List<SimilarMovie> movies, LocalDate creationDate) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.movies = movies;
        this.creationDate = creationDate;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<SimilarMovie> getMovies() {
        return movies;
    }

    public void setMovies(List<SimilarMovie> movies) {
        this.movies = movies;
    }

    public LocalDate getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(LocalDate creationDate) {
        this.creationDate = creationDate;
    }
}
