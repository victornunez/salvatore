package com.victornunez.salvatore.connector;

import com.victornunez.salvatore.config.PropertiesConfig;
import com.victornunez.salvatore.connector.dto.credits.CreditsDTO;
import com.victornunez.salvatore.connector.dto.movie.MovieDTO;
import com.victornunez.salvatore.connector.dto.reviews.ReviewsDTO;
import com.victornunez.salvatore.connector.dto.similar.SearchResultsDTO;
import com.victornunez.salvatore.connector.dto.similar.SimilarResultsDTO;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MovieDBConnector {
    private static final String MOVIE_URL = "/3/movie/{id}?api_key={token}";
    private static final String SIMILAR_MOVIE_URL = "/3/movie/{movie_id}/similar?api_key={token}";
    private static final String REVIEWS_URL = "/3/movie/{movie_id}/reviews?api_key={token}";
    private static final String CREDITS_URL = "/3/movie/{movie_id}/credits?api_key={token}";
    private static final String SEARCH_URL = "/3/search/movie/?api_key={token}&query={query}&page={page}";
    private RestTemplate restTemplate;
    private String token;

    public MovieDBConnector(RestTemplate movieDBRestTemplate, PropertiesConfig config){
        this.restTemplate = movieDBRestTemplate;
        this.token = config.getToken();
    }

    public MovieDTO getMovie(String id){
        return restTemplate.getForObject(MOVIE_URL, MovieDTO.class, id, token);
    }

    public ReviewsDTO getReviews(String id){
        return restTemplate.getForObject(REVIEWS_URL, ReviewsDTO.class, id, token);
    }

    public SimilarResultsDTO getSimilarMovies(String id){
        return restTemplate.getForObject(SIMILAR_MOVIE_URL, SimilarResultsDTO.class, id, token);
    }

    public CreditsDTO getCredits(String id){
        return restTemplate.getForObject(CREDITS_URL, CreditsDTO.class, id, token);
    }

    public SearchResultsDTO searchMovies(String query, Integer page){
        return restTemplate.getForObject(CREDITS_URL, SearchResultsDTO.class, token, query, page);
    }
}
