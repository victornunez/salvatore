package com.victornunez.salvatore.connector.exception;

import java.io.IOException;

public class MovieDBUnexpectedErrorException extends IOException {
    public MovieDBUnexpectedErrorException(String message) {
        super(message);
    }
}
