package com.victornunez.salvatore.config;

import com.victornunez.salvatore.controller.interceptor.ContextInterceptor;
import com.victornunez.salvatore.controller.interceptor.RequestInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MVCConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new ContextInterceptor());
        registry.addInterceptor(new RequestInterceptor());
    }

}