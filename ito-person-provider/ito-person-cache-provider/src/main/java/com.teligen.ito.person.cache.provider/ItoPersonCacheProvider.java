package com.teligen.ito.person.cache.provider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.teligen.ito.person.cache.provider"})
public class ItoPersonCacheProvider {
    public static void main(String[] args) {
        SpringApplication.run(ItoPersonCacheProvider.class, args);
    }
}
