package com.victornunez.salvatore.task;

import com.victornunez.salvatore.config.SalvatoreTaskExecutorConfig;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.stereotype.Component;

@Component
public class SalvatoreTaskExecutor {
    @Bean
    @Autowired
    public ThreadPoolTaskExecutor defaultTaskExecutor(SalvatoreTaskExecutorConfig config) {
        ThreadPoolTaskExecutor pool = new ThreadPoolTaskExecutor();
        pool.setCorePoolSize(config.getCorePoolSize());
        pool.setMaxPoolSize(config.getMaxPoolSize());
        pool.setQueueCapacity(config.getQueue());
        pool.setTaskDecorator(new SalvatoreTaskDecorator());
        pool.initialize();
        return pool;
    }
}

