package com.codebase.employeeSystem.configuration;

import com.codebase.employeeSystem.service.CustomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/*
@Configuration                              declare class as config class
@ConditionalOnProperty                      Config will be applied only when property is present
*/

@Configuration
@ConditionalOnProperty(
        name = "spring.profiles.active",
        havingValue = "test")
public class CustomAutoConfig {

    /*
    @ConditionalOnMissingBean to ensure Bean is created only when it does not exist
    */
    @Bean
    public CustomService getService(){
        return new CustomService();
    }

}
