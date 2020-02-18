package com.victornunez.salvatore.context;

public class ThreadLocalContext {
    private static final ThreadLocal<Context> context = new ThreadLocal<>();

    public static Context getContext() {
        return context.get();
    }

    public static void setContext(Context value) {
        context.set(value);
    }

    public static void clear() {
        context.remove();
    }
}
