package com.beyondvelocity;

import com.beyondvelocity.components.Application;
import com.beyondvelocity.utils.ContextProvider;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // initialize the context
        var context = new AnnotationConfigApplicationContext(ProjectConfig.class);
        ContextProvider.setContext(context);

        // execute the application
        context.getBean(Application.class).execute();
    }
}
