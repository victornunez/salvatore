package com.victornunez.salvatore.connector;

import com.victornunez.salvatore.connector.exception.MovieDBBadRequestException;
import com.victornunez.salvatore.connector.exception.MovieDBNotFoundException;
import com.victornunez.salvatore.connector.exception.MovieDBUnauthorizedException;

import com.victornunez.salvatore.connector.exception.MovieDBUnexpectedErrorException;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.client.ResponseErrorHandler;

import java.io.IOException;

@Component
public class MovieDBErrorHandler implements ResponseErrorHandler {
    @Override
    public boolean hasError(ClientHttpResponse response) throws IOException {
        return !response.getStatusCode().is2xxSuccessful();
    }

    @Override
    public void handleError(ClientHttpResponse response) throws IOException {
        switch(response.getStatusCode()) {
            case BAD_REQUEST:
                throw new MovieDBBadRequestException("400 error calling The MovieDB: invalid parameters.");
            case NOT_FOUND:
                throw new MovieDBNotFoundException("404 error calling The MovieDB: not found.");
            case UNAUTHORIZED:
                throw new MovieDBUnauthorizedException("401 error calling The MovieDB: not valid token.");
            default:
                throw new MovieDBUnexpectedErrorException(String.format("%s error calling The Movie DB", response.getRawStatusCode()));
        }
    }
}