package ru.example.temperaturemeasurer.configuration;

import com.mongodb.reactivestreams.client.MongoClient;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.mongo.MongoProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;

@Configuration
@RequiredArgsConstructor
public class ReactiveMongoConfig {

    private final MongoProperties mongoProperties;
    private final MongoClient mongoClient;

    @Bean
    public ReactiveMongoTemplate reactiveMongoTemplate() {
        return new ReactiveMongoTemplate(mongoClient, mongoProperties.getMongoClientDatabase());
    }

}
