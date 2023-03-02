package ru.example.temperaturemeasurer.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.reactive.ReactorClientHttpConnector;
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

}
