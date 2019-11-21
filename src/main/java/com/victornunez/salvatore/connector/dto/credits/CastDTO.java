package com.victornunez.salvatore.connector.dto.credits;

import com.fasterxml.jackson.annotation.JsonProperty;

public class CastDTO {
    @JsonProperty("cast_id") private Integer castId;
    private Integer order;
    private String character;
    @JsonProperty("credit_id") private String creditId;
    private String name;

    public Integer getCastId() {
        return castId;
    }

    public void setCastId(Integer castId) {
        this.castId = castId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public String getCharacter() {
        return character;
    }

    public void setCharacter(String character) {
        this.character = character;
    }

    public String getCreditId() {
        return creditId;
    }

    public void setCreditId(String creditId) {
        this.creditId = creditId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
