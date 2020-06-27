package com.teligen.ito.person.core.provider;

import org.mybatis.spring.annotation.MapperScan;
import org.mybatis.spring.annotation.MapperScans;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
@ComponentScan(basePackages = {"com.teligen.ito.person.core.provider.bussiness"})
public class PersonCoreProviderApp {
    public static void main(String[] args) {
        SpringApplication.run(PersonCoreProviderApp.class, args);
    }
}
