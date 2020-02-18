package com.victornunez.salvatore.connector.dto.similar;

import com.fasterxml.jackson.annotation.JsonProperty;

public class RelatedMovieDTO {
    private Integer id;
    @JsonProperty("original_title") private String originalTitle;
    @JsonProperty("release_date") private String releaseDate;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOriginalTitle() {
        return originalTitle;
    }

    public void setOriginalTitle(String originalTitle) {
        this.originalTitle = originalTitle;
    }

    public String getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(String releaseDate) {
        this.releaseDate = releaseDate;
    }
}
