package com.victornunez.salvatore.connector.exception;

import java.io.IOException;

public class MovieDBNotFoundException extends IOException {
    public MovieDBNotFoundException(String message) {
        super(message);
    }
}
