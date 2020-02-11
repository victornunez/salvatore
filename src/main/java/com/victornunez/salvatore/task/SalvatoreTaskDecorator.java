package com.victornunez.salvatore.task;

import com.victornunez.salvatore.context.Context;
import com.victornunez.salvatore.context.ThreadLocalContext;
import org.slf4j.MDC;
import org.springframework.core.task.TaskDecorator;

import java.util.Map;

public class SalvatoreTaskDecorator implements TaskDecorator {

    @Override
    public Runnable decorate(Runnable runnable) {
        Map<String, String> contextMap = MDC.getCopyOfContextMap();
        Context threadContext = ThreadLocalContext.getContext();
        return () -> {
            try {
                MDC.setContextMap(contextMap);
                ThreadLocalContext.setContext(threadContext);
                runnable.run();
            } finally {
                MDC.clear();
                ThreadLocalContext.clear();
            }
        };
    }
}
