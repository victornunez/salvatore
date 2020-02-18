package com.victornunez.salvatore.connector.dto.toprated;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class TopRatedResultsDTO {
    @JsonProperty("total_results") private Integer totalResults;
    private List<TopRatedMovieDTO> results;

    public Integer getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(Integer totalResults) {
        this.totalResults = totalResults;
    }

    public List<TopRatedMovieDTO> getResults() {
        return results;
    }

    public void setResults(List<TopRatedMovieDTO> results) {
        this.results = results;
    }
}
