package com.victornunez.salvatore.connector;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class MovieDBInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(MovieDBInterceptor.class);

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        LOGGER.info(String.format("%s request TMDB with URL: %s", request.getMethodValue(), request.getURI().toString()));
        return execution.execute(request, bytes);
    }
}
