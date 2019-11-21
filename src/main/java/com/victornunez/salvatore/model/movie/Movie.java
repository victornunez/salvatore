package com.victornunez.salvatore.model.movie;

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
    private Optional<List<String>> genres;
    private Optional<List<Review>> reviews;
    private Optional<List<SimilarMovie>> similarMovies;

    public Movie(String id, String title, String originalTitle, String originalLanguage, String overview, String releaseDate, Integer revenue, BigDecimal voteAverage) {
        this.id = id;
        this.title = title;
        this.originalTitle = originalTitle;
        this.originalLanguage = originalLanguage;
        this.overview = overview;
        this.releaseDate = releaseDate;
        this.revenue = revenue;
        this.voteAverage = voteAverage;
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

    public Optional<List<String>> getGenres() {
        return genres;
    }

    public void setGenres(Optional<List<String>> genres) {
        this.genres = genres;
    }

    public Optional<List<Review>> getReviews() {
        return reviews;
    }

    public void setReviews(Optional<List<Review>> reviews) {
        this.reviews = reviews;
    }

    public Optional<List<SimilarMovie>> getSimilarMovies() {
        return similarMovies;
    }

    public void setSimilarMovies(Optional<List<SimilarMovie>> similarMovies) {
        this.similarMovies = similarMovies;
    }
}
