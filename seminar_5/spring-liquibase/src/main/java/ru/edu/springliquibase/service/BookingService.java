package ru.edu.springliquibase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.edu.springliquibase.exception.IllegalBookingException;
import ru.edu.springliquibase.exception.NotFoundException;
import ru.edu.springliquibase.model.entity.Booking;
import ru.edu.springliquibase.model.entity.Client;
import ru.edu.springliquibase.model.entity.Restaurant;
import ru.edu.springliquibase.model.request.CreateBookingRequest;
import ru.edu.springliquibase.repository.BookingRepository;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;

    private final RestaurantService restaurantService;
    private final ClientService clientService;

    public Iterable<Booking> findAll() {
        return bookingRepository.findAll();
    }

    @Transactional
    public Booking book(CreateBookingRequest createBookingRequest) {
        clientService.findById(createBookingRequest.clientId())
            .orElseThrow(() -> new NotFoundException(createBookingRequest.clientId(), Client.class));
        restaurantService.findById(createBookingRequest.restaurantId())
            .orElseThrow(() -> new NotFoundException(createBookingRequest.restaurantId(), Restaurant.class));
        if (overlapsOtherBooking(createBookingRequest)) {
            throw new IllegalBookingException(createBookingRequest);
        }
        var booking = new Booking();
        booking.setTo(createBookingRequest.to());
        booking.setFrom(createBookingRequest.from());
        booking.setClientId(createBookingRequest.clientId());
        booking.setRestaurantId(createBookingRequest.restaurantId());
        return bookingRepository.save(booking);
    }

    private boolean overlapsOtherBooking(CreateBookingRequest createBookingRequest) {
        return !bookingRepository.findByRestaurantIdInPeriod(
            createBookingRequest.restaurantId(),
            createBookingRequest.from(),
            createBookingRequest.to()
        ).isEmpty();
    }

}
