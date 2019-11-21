package com.victornunez.salvatore.service.movie;

import com.victornunez.salvatore.connector.dto.credits.CreditsDTO;
import com.victornunez.salvatore.connector.dto.movie.MovieDTO;
import com.victornunez.salvatore.connector.dto.reviews.ReviewDTO;
import com.victornunez.salvatore.connector.dto.reviews.ReviewsDTO;
import com.victornunez.salvatore.connector.dto.similar.SimilarResultsDTO;
import com.victornunez.salvatore.model.movie.Movie;
import com.victornunez.salvatore.model.review.Review;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MovieTransformer {
    public Optional<Movie> transform (Optional<MovieDTO> movieOpt,
                            Optional<ReviewsDTO> reviewsOpt,
                            Optional<CreditsDTO> creditsOpt,
                            Optional<SimilarResultsDTO> relatedMoviesOpt){

        Optional<Movie> movie = movieOpt.map(this::convertMovie);

        Optional<List<Review>> reviews = reviewsOpt.map(ReviewsDTO::getReviews).map(
                reviewsDto -> reviewsDto.stream().limit(10).map(this::convertReview).collect(Collectors.toList()));

        movie.ifPresent(m -> m.setReviews(reviews));

        return movie;
    }

    private Movie convertMovie(MovieDTO movieDTO){
        return new Movie(movieDTO.getId(), movieDTO.getTitle(), movieDTO.getOriginalTitle(), movieDTO.getOriginalLanguage(), movieDTO.getOverview(), movieDTO.getReleaseDate(), movieDTO.getRevenue(), movieDTO.getVoteAverage());
    }

    private Review convertReview(ReviewDTO reviewDTO){
        return new Review(reviewDTO.getAuthor(), reviewDTO.getContent());
    }
}
