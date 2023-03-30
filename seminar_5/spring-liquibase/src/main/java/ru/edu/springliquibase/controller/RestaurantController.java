package ru.edu.springliquibase.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.springliquibase.model.entity.Restaurant;
import ru.edu.springliquibase.service.RestaurantService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/restaurant")
public class RestaurantController {

    private final RestaurantService restaurantService;


    @GetMapping
    public Iterable<Restaurant> getAll() {
        return restaurantService.findAll();
    }

}
