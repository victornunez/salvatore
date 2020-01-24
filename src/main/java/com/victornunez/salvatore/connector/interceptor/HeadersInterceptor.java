package com.victornunez.salvatore.connector.interceptor;

import com.victornunez.salvatore.context.ThreadLocalContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

import java.io.IOException;

public class HeadersInterceptor implements ClientHttpRequestInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(HeadersInterceptor.class);

    @Override
    public ClientHttpResponse intercept(
            HttpRequest request, byte[] bytes, ClientHttpRequestExecution execution) throws IOException {
        LOGGER.info("Customs headers propagation");
        ThreadLocalContext.getContext().getHeaders().forEach((key, value) -> request.getHeaders().add(key, value));
        return execution.execute(request, bytes);
    }
}
