package com.victornunez.salvatore.connector.exception;

import java.io.IOException;

public class MovieDBUnauthorizedException extends IOException {
    public MovieDBUnauthorizedException(String message) {
        super(message);
    }
}
