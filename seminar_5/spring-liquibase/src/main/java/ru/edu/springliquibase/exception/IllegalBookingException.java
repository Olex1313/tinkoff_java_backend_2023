package ru.edu.springliquibase.exception;

import ru.edu.springliquibase.model.request.CreateBookingRequest;

public class IllegalBookingException extends RuntimeException {

    public IllegalBookingException(CreateBookingRequest createBookingRequest) {
        super("Unable to book in period %s - %s for restaurant %d".formatted(
            createBookingRequest.from().toString(),
            createBookingRequest.to().toString(),
            createBookingRequest.restaurantId()
        ));
    }
}
