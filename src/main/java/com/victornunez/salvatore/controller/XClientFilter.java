package com.victornunez.salvatore.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.*;

@Component
@Order(1)
public class XClientFilter implements Filter {
    private static final Logger LOGGER = LoggerFactory.getLogger(XClientFilter.class);
    private static final String XCLIENT = "X-Client";

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        LOGGER.info("Validating X-Client header.");
        HttpServletRequest httpRequest = (HttpServletRequest) request;

        if (Objects.nonNull(httpRequest.getHeader(XCLIENT))){
            chain.doFilter(request, response);
        } else {
            throw new HttpClientErrorException(HttpStatus.BAD_REQUEST, "Missing X-Client header");
        }
    }

}
