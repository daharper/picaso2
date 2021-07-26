package com.beyondvelocity;

import com.beyondvelocity.utils.Rtti;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

@Configuration
@ComponentScan
public class ProjectConfig {
    @Bean
    public Rtti rtti() {
        return new Rtti(ProjectConfig.class.getPackageName());
    }
}
