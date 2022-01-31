package com.eladhakmon.rickandmortyapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.http.*;
import org.springframework.web.client.RestTemplate;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class})
public class RickAndMortyApiApplication {
    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public HttpHeaders httpHeaders() {
        return new HttpHeaders();
    }


    public static void main(String[] args) {
        SpringApplication.run(RickAndMortyApiApplication.class, args);
        System.out.println("IOC loaded...");

    }

}
