package com.victornunez.salvatore.service.list;

import com.victornunez.salvatore.model.list.CreationListInfo;
import com.victornunez.salvatore.model.list.MovieList;
import com.victornunez.salvatore.model.movie.SimilarMovie;
import com.victornunez.salvatore.storage.pojo.ListDAO;
import com.victornunez.salvatore.storage.pojo.MovieDAO;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Component
public class ListTransformer {

    public ListDAO createEmptyList(CreationListInfo info){
        return new ListDAO(
                info.getUser(),
                info.getName(),
                new ArrayList<>(),
                LocalDate.now());
    }

    MovieDAO createMovieDAO(String movieId) {
        return new MovieDAO(movieId, LocalDate.now());
    }

    public MovieList transformList(ListDAO list, List<SimilarMovie> movies){
        return new MovieList(list.getId(),
                list.getUser(),
                list.getName(),
                movies,
                list.getCreationDate());
    }
}
