package com.victornunez.salvatore.service.search;

import com.victornunez.salvatore.connector.MovieDBConnector;
import com.victornunez.salvatore.connector.dto.reviews.ReviewsDTO;
import com.victornunez.salvatore.connector.dto.similar.SearchResultsDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SearchService {
    @Autowired
    MovieDBConnector connector;

    public SearchResultsDTO searchMovies(String query, Integer page){
        return connector.searchMovies(query, page);
    }
}
