package com.victornunez.salvatore.connector.dto.reviews;

import java.util.List;

public class ReviewsDTO {
    private Integer id;
    private Integer page;
    private List<ReviewDTO> results;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public List<ReviewDTO> getResults() {
        return results;
    }

    public void setResults(List<ReviewDTO> results) {
        this.results = results;
    }
}
