package org.docencia.hotel.domain.impl;

import java.util.List;
import java.util.Set;

import org.docencia.hotel.domain.api.BookingDomain;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;
import org.w3c.dom.stylesheets.LinkStyle;

@Service
public class BookingDomainImpl implements BookingDomain {

    private final BookingService service;

    public BookingDomainImpl(BookingService service) {
        this.service = service;
    }

    @Override
    public List<Booking> findAll() {
        return service.findAll();
    }

    @Override
    public Booking findById(String id) {
        return service.findById(id);
    }

    @Override
    public Booking save(Booking booking) {
        return service.save(booking);
    }

    @Override
    public Boolean deleteById(String id) {
        return service.;
    }
}