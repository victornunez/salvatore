package com.victornunez.salvatore.connector;

import com.victornunez.salvatore.config.PropertiesConfig;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.DefaultUriBuilderFactory;

@Configuration
public class MovieDBRestConfig {
    @Bean
    @Autowired
    public RestTemplate movieDBRestTemplate(PropertiesConfig config, MovieDBErrorHandler errorHandler) {
        var requestConfig = RequestConfig.custom().build();
        var client = HttpClientBuilder.create().setDefaultRequestConfig(requestConfig).build();
        var factory = new HttpComponentsClientHttpRequestFactory(client);
        RestTemplate restTemplate = new RestTemplate(factory);
        restTemplate.setErrorHandler(errorHandler);
        restTemplate.setUriTemplateHandler(new DefaultUriBuilderFactory(config.getHost()));
        return restTemplate;
    }
}

