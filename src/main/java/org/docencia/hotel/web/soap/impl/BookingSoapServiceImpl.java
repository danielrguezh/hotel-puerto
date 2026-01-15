package org.docencia.hotel.web.soap.impl;

import java.util.List;

import org.docencia.hotel.domain.api.BookingDomain;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.web.soap.BookingSoapService;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
/**
 * @author mahoramas
 * @version 1.0.0
 */
@Service
@WebService(
        endpointInterface = "org.docencia.hotel.web.soap.BookingSoapService",
        targetNamespace = "http://hotel.docencia.org/ws",
        serviceName = "BookingSoapService",
        portName = "BookingSoapPort"
)
public class BookingSoapServiceImpl implements BookingSoapService {

    private final BookingDomain bookingDomain;

    public BookingSoapServiceImpl(BookingDomain bookingDomain) {
        this.bookingDomain = bookingDomain;
    }

    @Override
    public Booking getBookingById(String id) {
        return bookingDomain.findById(id);
    }

    @Override
    public Booking saveBooking(Booking booking) {
        return bookingDomain.save(booking);
    }

    @Override
    public List<Booking> findAllBooking() {
        return bookingDomain.findAll();
    }

    @Override
    public boolean deleteBookingById(String id) {
        return bookingDomain.deleteById(id);
    }

}