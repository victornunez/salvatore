package com.victornunez.salvatore.storage;

import com.victornunez.salvatore.storage.pojo.ListDAO;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface ListRepository extends MongoRepository<ListDAO, String>, CustomMovieListOperations {}
