package com.victornunez.salvatore.connector.exception;

public class MovieDBUnauthorizedException extends TMDBException {
    public MovieDBUnauthorizedException(String message) {
        super(message);
    }
}
