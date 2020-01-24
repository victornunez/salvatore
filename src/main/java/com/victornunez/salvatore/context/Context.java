package com.victornunez.salvatore.context;

import java.util.Map;

public class Context {
    private Map<String, String> headers;

    public Context(Map<String, String> headers) {
        this.headers = headers;
    }

    public Map<String, String> getHeaders() {
        return headers;
    }
}
