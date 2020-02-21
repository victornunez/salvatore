package com.victornunez.salvatore.controller.interceptor;

import com.victornunez.salvatore.context.Context;
import com.victornunez.salvatore.context.ThreadLocalContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.MDC;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.Collections;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;
import java.util.function.Function;
import java.util.stream.Collectors;

public class ContextInterceptor implements HandlerInterceptor {
    private static final Logger LOGGER = LoggerFactory.getLogger(RequestInterceptor.class);
    private static final String XUOW = "X-UOW";
    private static final String UNDEFINED_HOST = "UNDEFINED_HOST";
    private static final String HOST = "host";
    private static final String XMOVIE_PREFIX = "xmovie";

    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String uow = getUOW(request);
        LOGGER.info(String.format("Creating context for UOW: %s",  uow));
        MDC.put(XUOW, uow);
        MDC.put(HOST, getHost());
        createContext(request, uow);
        return true;
    }

    private void createContext(HttpServletRequest request, String uow) {
        Map<String, String> xMovieHeaders = Collections.list(request.getHeaderNames())
                            .stream()
                            .filter(h -> h.startsWith(XMOVIE_PREFIX))
                            .collect(Collectors.toMap(Function.identity(), request::getHeader));

        xMovieHeaders.put(XUOW, uow);
        ThreadLocalContext.setContext(new Context(xMovieHeaders));
    }

    private String getUOW(HttpServletRequest request){
       return Optional.ofNullable(request.getHeader(XUOW)).orElseGet(() -> UUID.randomUUID().toString());
    }

    private String getHost(){
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException ex) {
            return UNDEFINED_HOST;
        }
    }
}
