package com.victornunez.salvatore.snapshot;

import com.victornunez.salvatore.connector.MovieDBConnector;
import com.victornunez.salvatore.connector.dto.toprated.TopRatedResultsDTO;
import com.victornunez.salvatore.context.Context;
import com.victornunez.salvatore.context.ThreadLocalContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;

@Component
public class TopRatedMoviesSnapshot {
    private static AtomicReference<Set<Integer>> topRatedMovies = new AtomicReference<>();
    private static final String XUOW = "X-UOW";
    private static final String UOW = "topRatedSnapshot";
    private MovieDBConnector connector;
    private TopRatedMoviesTransformer transformer;

    @Autowired
    public TopRatedMoviesSnapshot(MovieDBConnector connector, TopRatedMoviesTransformer transformer) {
        this.connector = connector;
        this.transformer = transformer;
    }

    @Scheduled(fixedDelay = 1800000)
    public void refresh() {
        ThreadLocalContext.setContext(this.createContext());
        TopRatedResultsDTO results = this.connector.getTopRatedMovies();
        topRatedMovies.set(this.transformer.transformMovies(results));
    }

    public boolean isTopRated(Integer movieId) {
        return topRatedMovies.get().contains(movieId);
    }

    private Context createContext() {
        Map<String, String> customHeaders = new HashMap<>();
        customHeaders.put(XUOW, UOW);
        return new Context(customHeaders);
    }

}
