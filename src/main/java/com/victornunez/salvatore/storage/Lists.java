package com.victornunez.salvatore.storage;

import com.victornunez.salvatore.model.list.MovieList;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

import java.util.*;

@Component
@Scope(value = WebApplicationContext.SCOPE_SESSION, proxyMode = ScopedProxyMode.TARGET_CLASS)
public class Lists {
    Map<String, MovieList> lists;

    public Lists() {
        this.lists = new HashMap<>();
    }

    public Optional<MovieList> getList(String id) {
        return Optional.ofNullable(lists.get(id));
    }

    public Optional<MovieList> createList(String user, String name){
        String id = UUID.randomUUID().toString();
        lists.put(id, new MovieList(id, user, name));
        return Optional.ofNullable(lists.get(id));
    }

    public Optional<MovieList> deleteList(String id) {
        return Optional.ofNullable(lists.remove(id));
    }

    public Optional<MovieList> addMovies(String id, List<String> movies) {
        return Optional.ofNullable(lists.get(id)).map(l -> {
            l.getMovies().addAll(movies);
            return l;
        });
    }

    public Optional<MovieList> removeMovies(String id, List<String> movies) {
        return Optional.ofNullable(lists.get(id)).map(l -> {
            l.getMovies().removeAll(movies);
            return l;
        });
    }
}
