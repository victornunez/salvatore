package com.victornunez.salvatore.service.list;

import com.victornunez.salvatore.model.list.CreationListInfo;
import com.victornunez.salvatore.model.list.MovieList;
import com.victornunez.salvatore.model.movie.SimilarMovie;
import com.victornunez.salvatore.service.movie.MovieService;
import com.victornunez.salvatore.storage.ListRepository;
import com.victornunez.salvatore.storage.pojo.ListDAO;
import com.victornunez.salvatore.storage.pojo.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ListService {
    private ListRepository repository;
    private ListTransformer listTransformer;
    private MovieService movieService;

    @Autowired
    public ListService(
            ListRepository repository,
            ListTransformer listTransformer,
            MovieService movieService
    ) {
        this.repository = repository;
        this.listTransformer = listTransformer;
        this.movieService = movieService;
    }

    public Optional<MovieList> getList(String id) {
        return repository.findById(id).map(this::buildUserList);
    }

    public MovieList createList(CreationListInfo info) {
        ListDAO newList = this.listTransformer.createEmptyList(info);
        return buildUserList(this.repository.save(newList));
    }

    public void deleteList(String id) {
        repository.deleteById(id);
    }

    public Optional<MovieList> addMovies(String id, List<String> movies) {
        List<MovieDAO> newMovies = movies.stream().map(listTransformer::createMovieDAO).collect(Collectors.toList());
        repository.addMovies(id, newMovies);
        return repository.findById(id).map(this::buildUserList);
    }

    public Optional<MovieList> removeMovies(String id, List<String> movies) {
        repository.deleteMovies(id, movies);
        return repository.findById(id).map(this::buildUserList);
    }

    private MovieList buildUserList(ListDAO list){
        List<String> ids = list.getMovies().stream().map(MovieDAO::getId).collect(Collectors.toList());
        List<SimilarMovie> movies = this.movieService.getMovies(ids);
        return this.listTransformer.transformList(list, movies);
    }
}
