package com.beyondvelocity.core;

import org.springframework.context.ApplicationContext;

/*
 * Provides the Spring Context to clients.
 */
public class ContextProvider {
    private static ApplicationContext context;

    /*
     * Gets the context.
     */
    public static ApplicationContext getContext() {
        return context;
    }

    /*
     * Sets the context.
     */
    public static void setContext(ApplicationContext ac) {
        assert context == null : "context should be initialized once on startup";

        context = ac;
    }
}
