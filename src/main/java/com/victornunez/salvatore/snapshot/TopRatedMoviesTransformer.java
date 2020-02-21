package com.victornunez.salvatore.snapshot;

import com.victornunez.salvatore.connector.dto.toprated.TopRatedMovieDTO;
import com.victornunez.salvatore.connector.dto.toprated.TopRatedResultsDTO;
import org.springframework.stereotype.Component;

import java.util.Set;
import java.util.stream.Collectors;

@Component
public class TopRatedMoviesTransformer {

    public Set<Integer> transformMovies(TopRatedResultsDTO topRatedMovies){
        return topRatedMovies.getResults().stream().map(TopRatedMovieDTO::getId).collect(Collectors.toSet());
    }
}
