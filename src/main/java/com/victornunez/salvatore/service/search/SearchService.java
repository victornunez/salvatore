package com.victornunez.salvatore.service.search;

import com.victornunez.salvatore.connector.MovieDBConnector;
import com.victornunez.salvatore.connector.dto.similar.SearchResultsDTO;
import com.victornunez.salvatore.connector.dto.similar.SimilarResultsDTO;
import com.victornunez.salvatore.connector.exception.MovieDBNotFoundException;
import com.victornunez.salvatore.model.movie.SimilarMovie;
import com.victornunez.salvatore.service.movie.MovieTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class SearchService {
    private MovieDBConnector connector;
    private MovieTransformer transformer;

    @Autowired
    public SearchService(MovieDBConnector connector, MovieTransformer transformer) {
        this.connector = connector;
        this.transformer = transformer;
    }

    public List<SimilarMovie> searchMovies(String query, Integer page){
        try {
            SearchResultsDTO relatedMovies = connector.searchMovies(query, page);
            return transformer.transformSearch(relatedMovies);
        } catch (MovieDBNotFoundException e) {
            return new ArrayList<SimilarMovie>();
        }
    }
}
