package com.victornunez.salvatore.connector.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;
import java.util.stream.Collectors;

public class MovieDBInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieDBInterceptor.class);

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        LOGGER.info(String.format("%s TMDB request with URL: %s with headers: %s", request.getMethodValue(), request.getURI().toString(), getHeaders(request)));
        return execution.execute(request, bytes);
    }

    private String getHeaders(HttpRequest request) {
        return request.getHeaders().entrySet()
                .stream()
                .map(e -> e.getKey() + "=" + e.getValue())
                .collect(Collectors.joining(" - "));
    }
}
