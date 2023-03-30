package ru.edu.springliquibase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.edu.springliquibase.model.entity.Restaurant;
import ru.edu.springliquibase.repository.RestaurantRepository;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class RestaurantService {

    private final RestaurantRepository restaurantRepository;

    public Iterable<Restaurant> findAll() {
        return restaurantRepository.findAll();
    }

    public Optional<Restaurant> findById(long restaurantId) {
        return restaurantRepository.findById(restaurantId);
    }

}
