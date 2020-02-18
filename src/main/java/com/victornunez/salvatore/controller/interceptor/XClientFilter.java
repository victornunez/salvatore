package com.victornunez.salvatore.controller.interceptor;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
            HttpServletResponse httpResponse = (HttpServletResponse) response;
            httpResponse.sendError(HttpServletResponse.SC_BAD_REQUEST, "X-Client header is mandatory");
            LOGGER.info("BAD REQUEST: X-Client header is mandatory");
        }
    }

}
