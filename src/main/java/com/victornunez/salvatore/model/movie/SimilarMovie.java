package com.victornunez.salvatore.model.movie;

public class SimilarMovie {
    private Integer id;
    private String originalTitle;
    private String releaseDate;

    public SimilarMovie(Integer id, String originalTitle, String releaseDate) {
        this.id = id;
        this.originalTitle = originalTitle;
        this.releaseDate = releaseDate;
    }

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
