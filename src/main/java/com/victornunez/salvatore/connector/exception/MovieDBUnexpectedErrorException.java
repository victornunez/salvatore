package com.victornunez.salvatore.connector.exception;

public class MovieDBUnexpectedErrorException extends TMDBException {
    public MovieDBUnexpectedErrorException(String message) {
        super(message);
    }
}
