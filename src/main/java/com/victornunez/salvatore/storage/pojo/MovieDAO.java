package com.victornunez.salvatore.storage.pojo;

import com.fasterxml.jackson.annotation.JsonCreator;

import java.time.LocalDate;

public class MovieDAO {
  private String id;
  private LocalDate additionDate;

  @JsonCreator
  public MovieDAO(String id, LocalDate additionDate) {
    this.id = id;
    this.additionDate = additionDate;
  }

  public String getId() {
    return id;
  }

  public LocalDate getAdded() {
    return additionDate;
  }
}

