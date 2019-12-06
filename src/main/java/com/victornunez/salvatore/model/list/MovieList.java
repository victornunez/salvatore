package com.victornunez.salvatore.model.list;

import java.util.ArrayList;
import java.util.Set;

import static org.hibernate.validator.internal.util.CollectionHelper.newHashSet;

public class MovieList {
    private String id;
    private String user;
    private String name;
    private Set<String> movies;

    public MovieList(String id, String user, String name) {
        this.id = id;
        this.user = user;
        this.name = name;
        this.movies = newHashSet();
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

    public Set<String> getMovies() {
        return movies;
    }

    public void setMovies(Set<String> movies) {
        this.movies = movies;
    }
}
