package com.victornunez.salvatore.service.movie;

import com.victornunez.salvatore.connector.MovieDBConnector;
import com.victornunez.salvatore.connector.dto.credits.CreditsDTO;
import com.victornunez.salvatore.connector.dto.movie.MovieDTO;
import com.victornunez.salvatore.connector.dto.reviews.ReviewsDTO;
import com.victornunez.salvatore.connector.dto.similar.SimilarResultsDTO;
import com.victornunez.salvatore.connector.exception.TMDBException;
import com.victornunez.salvatore.model.movie.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.ExecutionException;

@Service
public class MovieService {
    private MovieDBConnector connector;
    private MovieTransformer transformer;
    private ThreadPoolTaskExecutor executor;

    @Autowired
    public MovieService(MovieDBConnector connector, MovieTransformer transformer, ThreadPoolTaskExecutor defaultTaskExecutor) {
        this.connector = connector;
        this.transformer = transformer;
        this.executor = defaultTaskExecutor;
    }

    public Optional<Movie> getMovie(String id){
        MovieDTO movieDto = connector.getMovie(id);

        CompletableFuture<Optional<ReviewsDTO>> reviewsF =
                CompletableFuture.supplyAsync(() -> getReviewsDTO(id), executor);

        CompletableFuture<Optional<CreditsDTO>> creditsF =
                CompletableFuture.supplyAsync(() -> getCreditsDTO(id), executor);

        CompletableFuture<Optional<SimilarResultsDTO>> relatedMoviesF =
                CompletableFuture.supplyAsync(() -> getSimilarResultsDTO(id), executor);

        try {
            CompletableFuture<Movie> movie = reviewsF.thenCompose(r ->
                                                    creditsF.thenCombine(relatedMoviesF,
                                                            (c, s) -> transformer.transformMovie(movieDto, r, c, s)));

            return Optional.of(movie.get());
        } catch (InterruptedException | ExecutionException e) {
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
