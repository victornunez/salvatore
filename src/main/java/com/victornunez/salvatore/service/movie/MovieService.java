package com.victornunez.salvatore.service.movie;

import com.victornunez.salvatore.connector.MovieDBConnector;
import com.victornunez.salvatore.connector.dto.credits.CreditsDTO;
import com.victornunez.salvatore.connector.dto.movie.MovieDTO;
import com.victornunez.salvatore.connector.dto.reviews.ReviewsDTO;
import com.victornunez.salvatore.connector.dto.similar.SimilarResultsDTO;
import com.victornunez.salvatore.connector.exception.MovieDBNotFoundException;
import com.victornunez.salvatore.connector.exception.TMDBException;
import com.victornunez.salvatore.model.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MovieService {
    private MovieDBConnector connector;
    private MovieTransformer transformer;

    @Autowired
    public MovieService(MovieDBConnector connector, MovieTransformer transformer) {
        this.connector = connector;
        this.transformer = transformer;
    }

    public Optional<Movie> getMovie(String id){
        try {
            MovieDTO movies = connector.getMovie(id);

            Optional<ReviewsDTO> reviews = getReviewsDTO(id);
            Optional<CreditsDTO> credits = getCreditsDTO(id);
            Optional<SimilarResultsDTO> relatedMovies = getSimilarResultsDTO(id);

            return Optional.of(transformer.transformMovie(movies, reviews, credits, relatedMovies));
        } catch (MovieDBNotFoundException e) {
            return Optional.empty();
        }
    }

    private Optional<SimilarResultsDTO> getSimilarResultsDTO(String id) {
        try {
            return Optional.ofNullable(connector.getSimilarMovies(id));
        } catch (TMDBException e){
            return Optional.empty();
        }
    }

    private Optional<CreditsDTO> getCreditsDTO(String id) {
        try {
            return Optional.ofNullable(connector.getCredits(id));
        } catch (TMDBException e){
            return Optional.empty();
        }
    }

    private Optional<ReviewsDTO> getReviewsDTO(String id) {
        try {
            return Optional.ofNullable(connector.getReviews(id));
        } catch (TMDBException e){
            return Optional.empty();
        }
    }


}
