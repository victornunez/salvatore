package com.victornunez.salvatore.storage.pojo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;

@Document("lists")
public class ListDAO {
  @Id
  private String id;
  private String user;
  private String name;
  private List<MovieDAO> movies;
  private LocalDate creationDate;

  public ListDAO(String user, String name, List<MovieDAO> movies, LocalDate creationDate) {
    this.user = user;
    this.name = name;
    this.movies = movies;
    this.creationDate = creationDate;
  }

  public String getId() {
    return id;
  }

  public String getUser() {
    return user;
  }

  public String getName() {
    return name;
  }

  public List<MovieDAO> getMovies() {
    return movies;
  }

  public LocalDate getCreationDate() {
    return creationDate;
  }
}

