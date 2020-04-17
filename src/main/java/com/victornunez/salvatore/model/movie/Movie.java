package com.victornunez.salvatore.model.movie;

import com.victornunez.salvatore.model.credits.Cast;
import com.victornunez.salvatore.model.credits.Crew;
import com.victornunez.salvatore.model.review.Review;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public class Movie {
    private String id;
    private String title;
    private String originalTitle;
    private String originalLanguage;
    private String overview;
    private String releaseDate;
    private Integer revenue;
    private BigDecimal voteAverage;
    private Boolean isTopRated;
    private List<String> genres;
    private List<Review> reviews;
    private List<SimilarMovie> similarMovies;
    private List<Cast> cast;
    private List<Crew> crew;

    public Movie(String id, String title, String originalTitle, String originalLanguage, String overview, String releaseDate, Integer revenue, BigDecimal voteAverage, Boolean isTopRated, List<String> genres, List<Review> reviews, List<SimilarMovie> similarMovies, List<Cast> cast, List<Crew> crew) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.voteAverage = voteAverage;
        this.isTopRated = isTopRated;
        this.genres = genres;
        this.reviews = reviews;
        this.similarMovies = similarMovies;
        this.cast = cast;
        this.crew = crew;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getOriginalLanguage() {
        return originalLanguage;
    }

    public void setOriginalLanguage(String originalLanguage) {
        this.originalLanguage = originalLanguage;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }

    public Integer getRevenue() {
        return revenue;
    }

    public void setRevenue(Integer revenue) {
        this.revenue = revenue;
    }

    public BigDecimal getVoteAverage() {
        return voteAverage;
    }

    public void setVoteAverage(BigDecimal voteAverage) {
        this.voteAverage = voteAverage;
    }

    public Boolean isTopRated() {
        return isTopRated;
    }

    public void setTopRated(Boolean topRated) {
        isTopRated = topRated;
    }

    public List<String> getGenres() {
        return genres;
    }

    public void setGenres(List<String> genres) {
        this.genres = genres;
    }

    public List<Review> getReviews() {
        return reviews;
    }

    public void setReviews(List<Review> reviews) {
        this.reviews = reviews;
    }

    public List<SimilarMovie> getSimilarMovies() {
        return similarMovies;
    }

    public void setSimilarMovies(List<SimilarMovie> similarMovies) {
        this.similarMovies = similarMovies;
    }

    public List<Cast> getCast() {
        return cast;
    }

    public void setCast(List<Cast> cast) {
        this.cast = cast;
    }

    public List<Crew> getCrew() {
        return crew;
    }

    public void setCrew(List<Crew> crew) {
        this.crew = crew;
    }
}
