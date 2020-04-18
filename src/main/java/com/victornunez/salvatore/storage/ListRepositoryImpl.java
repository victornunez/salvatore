package com.victornunez.salvatore.storage;

import com.victornunez.salvatore.storage.pojo.ListDAO;
import com.victornunez.salvatore.storage.pojo.MovieDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

import java.util.List;

public class ListRepositoryImpl implements CustomMovieListOperations {
    private static final String ID = "id";
    private static final String MOVIES = "movies";
    private MongoTemplate template;

    @Autowired
    public ListRepositoryImpl(MongoTemplate template) {
        this.template = template;
    }


    @Override
    public void addMovies(String id, List<MovieDAO> movies) {
        Query query = Query.query(Criteria.where(ID).is(id));
        Update update = new Update().push(MOVIES).each(movies);
        template.updateFirst(query, update, ListDAO.class);
    }

    @Override
    public void deleteMovies(String id, List<String> movies) {
        Query query = Query.query(Criteria.where(ID).is(id));
        Update update = new Update().pull(MOVIES, Query.query(Criteria.where(ID).in(movies)));
        template.updateFirst(query, update, ListDAO.class);
    }
}
