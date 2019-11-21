package com.victornunez.salvatore.service.movie;

import com.victornunez.salvatore.connector.MovieDBConnector;
import com.victornunez.salvatore.connector.dto.credits.CreditsDTO;
import com.victornunez.salvatore.connector.dto.movie.MovieDTO;
import com.victornunez.salvatore.connector.dto.reviews.ReviewsDTO;
import com.victornunez.salvatore.connector.dto.similar.SimilarResultsDTO;
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
            Optional<MovieDTO> movies = Optional.ofNullable(connector.getMovie(id));
            Optional<ReviewsDTO> reviews = Optional.ofNullable(connector.getReviews(id));
            Optional<CreditsDTO> credits = Optional.ofNullable(connector.getCredits(id));
            Optional<SimilarResultsDTO> relatedMovies = Optional.ofNullable(connector.getSimilarMovies(id));
            return transformer.transform(movies, reviews, credits, relatedMovies);
        } catch (RuntimeException e) {
            return Optional.empty();
        }
    }
}
