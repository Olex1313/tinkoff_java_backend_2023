package ru.edu.springliquibase.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.support.TransactionTemplate;
import ru.edu.springliquibase.exception.IllegalBookingException;
import ru.edu.springliquibase.exception.NotFoundException;
import ru.edu.springliquibase.model.entity.Booking;
import ru.edu.springliquibase.model.entity.Client;
import ru.edu.springliquibase.model.entity.Restaurant;
import ru.edu.springliquibase.model.request.ChangeBookingTimeRequest;
import ru.edu.springliquibase.model.request.CreateBookingRequest;
import ru.edu.springliquibase.repository.BookingRepository;

import java.util.List;


@Service
@RequiredArgsConstructor
public class BookingService {

    private final BookingRepository bookingRepository;
    private final TransactionTemplate transactionTemplate;

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

    public Booking updateBookingTime(Long bookingId, ChangeBookingTimeRequest request) {
        return transactionTemplate.execute(transactionStatus -> {
            Booking existingBooking = bookingRepository.findById(bookingId)
                .orElseThrow(() -> new NotFoundException(bookingId, Booking.class));
            List<Booking> overlappingBookings = bookingRepository.findInOverlappingPeriod(request.from(), request.to());
            if (!overlappingBookings.isEmpty()) {
                throw new IllegalBookingException(
                    new CreateBookingRequest(
                        request.from(), request.to(),
                        existingBooking.getRestaurantId(), existingBooking.getClientId()
                    )
                );
            }
            int updateCount = bookingRepository.updatePeriod(bookingId, request.from(), request.to());
            if (updateCount != 1) {
                throw new IllegalStateException("Unexpected amount of bookings changed");
            }
            var changedBooking = new Booking();
            changedBooking.setId(existingBooking.getId());
            changedBooking.setFrom(request.from());
            changedBooking.setTo(request.to());
            changedBooking.setClientId(existingBooking.getClientId());
            changedBooking.setRestaurantId(existingBooking.getRestaurantId());
            return changedBooking;
        });
    }

}
