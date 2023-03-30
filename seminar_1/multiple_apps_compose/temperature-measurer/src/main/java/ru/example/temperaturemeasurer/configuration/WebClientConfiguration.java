package ru.example.temperaturemeasurer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.netty.http.client.HttpClient;


@Configuration
public class WebClientConfiguration {

    @Bean
    public WebClient webClient() {
        HttpClient httpClient = HttpClient
                .create();
        return WebClient.builder()
                .clientConnector(new ReactorClientHttpConnector(httpClient))
                .build();
    }

    @Bean
    public RestTemplate restTemplate() {
        RestTemplate restTemplate = new RestTemplate();
        String fooResourceUrl
            = "http://localhost:8080/spring-rest/foos";
        ResponseEntity<String> response
            = restTemplate.getForEntity(fooResourceUrl + "/1", String.class);
        return restTemplate;
    }

}
