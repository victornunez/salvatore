package com.victornunez.salvatore.service.movie;

import com.victornunez.salvatore.aspect.Performance;
import com.victornunez.salvatore.connector.dto.credits.CastDTO;
import com.victornunez.salvatore.connector.dto.credits.CreditsDTO;
import com.victornunez.salvatore.connector.dto.credits.CrewDTO;
import com.victornunez.salvatore.connector.dto.movie.GenreDTO;
import com.victornunez.salvatore.connector.dto.movie.MovieDTO;
import com.victornunez.salvatore.connector.dto.reviews.ReviewDTO;
import com.victornunez.salvatore.connector.dto.reviews.ReviewsDTO;
import com.victornunez.salvatore.connector.dto.similar.RelatedMovieDTO;
import com.victornunez.salvatore.connector.dto.similar.SearchResultsDTO;
import com.victornunez.salvatore.connector.dto.similar.SimilarResultsDTO;
import com.victornunez.salvatore.model.credits.Cast;
import com.victornunez.salvatore.model.credits.Crew;
import com.victornunez.salvatore.model.credits.Job;
import com.victornunez.salvatore.model.movie.Movie;
import com.victornunez.salvatore.model.movie.SimilarMovie;
import com.victornunez.salvatore.model.review.Review;
import com.victornunez.salvatore.snapshot.TopRatedMoviesSnapshot;
import com.victornunez.salvatore.snapshot.TopRatedMoviesTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
public class MovieTransformer {
    private static final Integer MAX_SIZE = 10;
    private TopRatedMoviesSnapshot topRatedMoviesSnapshot;

    @Autowired
    public MovieTransformer(TopRatedMoviesSnapshot topRatedMoviesSnapshot) {
        this.topRatedMoviesSnapshot = topRatedMoviesSnapshot;
    }

    @Performance
    public Movie transformMovie (MovieDTO movie,
                                 Optional<ReviewsDTO> reviewsOpt,
                                 Optional<CreditsDTO> creditsOpt,
                                 Optional<SimilarResultsDTO> relatedMoviesOpt) {


        return convertMovie(movie,
                this.convertGenres(movie.getGenres()),
                this.convertReviews(reviewsOpt),
                this.convertSimilarMovies(relatedMoviesOpt),
                this.convertCastList(creditsOpt),
                this.convertCrewList(creditsOpt));
    }

    public List<SimilarMovie> transformSearch(SearchResultsDTO searchResultsDTO){
        return searchResultsDTO.getResults().stream().map(this::convertSimilarMovie).collect(Collectors.toList());
    }

    private Movie convertMovie(MovieDTO movieDTO, List<String> genres, List<Review> reviews, List<SimilarMovie> similarMovies, List<Cast> cast, List<Crew> crew) {
        return new Movie(movieDTO.getId(),
                movieDTO.getTitle(),
                movieDTO.getOriginalTitle(),
                movieDTO.getOriginalLanguage(),
                movieDTO.getOverview(),
                movieDTO.getReleaseDate(),
                movieDTO.getRevenue(),
                movieDTO.getVoteAverage(),
                this.topRatedMoviesSnapshot.isTopRated(Integer.parseInt(movieDTO.getId())),
                genres,
                reviews,
                similarMovies,
                cast,
                crew);
    }

    private List<String> convertGenres(List<GenreDTO> genres) {
        return genres.stream().map(GenreDTO::getName).collect(Collectors.toList());
    }

    private List<Review> convertReviews(Optional<ReviewsDTO> reviewsOpt) {
        return reviewsOpt.map(ReviewsDTO::getResults)
                .map(reviewsDto -> reviewsDto.stream().limit(MAX_SIZE).map(this::convertReview).collect(Collectors.toList()))
                .orElse(new ArrayList<Review>());
    }

    private Review convertReview(ReviewDTO reviewDTO) {
        return new Review(reviewDTO.getAuthor(), reviewDTO.getContent());
    }

    private List<SimilarMovie> convertSimilarMovies(Optional<SimilarResultsDTO> similarResultsOpt) {
        return similarResultsOpt.map(SimilarResultsDTO::getResults)
                .map(similarMoviesDto -> similarMoviesDto.stream().limit(10).map(this::convertSimilarMovie).collect(Collectors.toList()))
                .orElse(new ArrayList<SimilarMovie>());
    }

    private SimilarMovie convertSimilarMovie(RelatedMovieDTO relatedMovie) {
        return new SimilarMovie(relatedMovie.getId(), relatedMovie.getOriginalTitle(), relatedMovie.getReleaseDate());
    }

    private List<Cast> convertCastList(Optional<CreditsDTO> creditsDTO) {
        return creditsDTO.map(credits -> this.convertCast(credits.getCast())).orElse(new ArrayList<Cast>());
    }

    private List<Cast> convertCast(List<CastDTO> castDTOS) {
        return castDTOS.stream().limit(MAX_SIZE).map(castDTO -> new Cast(castDTO.getCharacter(), castDTO.getName())).collect(Collectors.toList());
    }

    private List<Crew> convertCrewList(Optional<CreditsDTO> creditsDTO) {
        return creditsDTO.map(credits -> this.convertCrew(credits.getCrew())).orElse(new ArrayList<Crew>());
    }

    private List<Crew> convertCrew(List<CrewDTO> crewDTOS) {
        return crewDTOS.stream().filter(this::filterCrew).map(crewDTO -> new Crew(crewDTO.getJob(), crewDTO.getName())).collect(Collectors.toList());
    }

    private boolean filterCrew(CrewDTO crewDTO) {
        return Job.Director.toString().equalsIgnoreCase(crewDTO.getJob()) || Job.Novel.toString().equalsIgnoreCase(crewDTO.getJob());
    }
}
