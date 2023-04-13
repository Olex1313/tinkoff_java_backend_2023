package ru.edu.springliquibase.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.edu.springliquibase.model.entity.Booking;
import ru.edu.springliquibase.model.request.ChangeBookingTimeRequest;
import ru.edu.springliquibase.model.request.CreateBookingRequest;
import ru.edu.springliquibase.service.BookingService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/booking")
public class BookingController {

    private final BookingService bookingService;

    @PostMapping
    public Booking doBooking(@RequestBody CreateBookingRequest createBookingRequest) {
        return bookingService.book(createBookingRequest);
    }

    @PatchMapping("/{id}")
    public Booking changeTime(@PathVariable("id") Long bookingId, @RequestBody
    ChangeBookingTimeRequest changeBookingTimeRequest) {
        return bookingService.updateBookingTime(bookingId, changeBookingTimeRequest);
    }

    @GetMapping
    public Iterable<Booking> getAll() {
        return bookingService.findAll();
    }

}
