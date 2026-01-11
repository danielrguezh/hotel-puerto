package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    @Override
    public List<Booking> findAll() {
        return null;
    }

    @Override
    public Booking findById(String id) {
        return null;
    }
    // TODO: inyectar repositorios + mappers y aplicar lógica
}
