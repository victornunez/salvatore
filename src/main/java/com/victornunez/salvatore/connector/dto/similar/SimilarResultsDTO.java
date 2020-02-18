package com.victornunez.salvatore.connector.dto.similar;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SimilarResultsDTO {
    @JsonProperty("total_results") private Integer totalResults;
    private List<RelatedMovieDTO> results;

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<RelatedMovieDTO> getResults() {
        return results;
    }

    public void setResults(List<RelatedMovieDTO> results) {
        this.results = results;
    }
}
