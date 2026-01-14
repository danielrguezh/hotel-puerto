package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.mapper.jpa.BookingMapper;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.repository.jpa.BookingRepository;
import org.docencia.hotel.service.api.BookingService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class BookingServiceImpl implements BookingService {
    private final BookingRepository repository;
    private final BookingMapper mapper;

    public BookingServiceImpl(BookingRepository repository, BookingMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Booking> findAll() {
        List<Booking> bookings =new ArrayList<>();
        if (repository.count() >0) {
            bookings = mapper.toBookings(repository.findAll());
        }

        return bookings;
    }

    @Override
    public Booking findById(String id) {
        return mapper.toDomain(repository.findById(id).orElse(null));
    }

    @Override
    public Booking save(Booking booking) {
        if (booking.getId() == null) {
            List<BookingEntity> bookings = repository .findAll();
            if (bookings.isEmpty()) {
                booking.setId("B1");
            } else {
                BookingEntity last = bookings.get(bookings.size() - 1);
                int newId = Integer.parseInt(last.getId().replace("B", "")) + 1;
                booking.setId("B" + newId);
            }
        }
        return mapper.toDomain(repository.save(mapper.toEntity(booking)));
    }

    @Override
    public boolean deleteById(String id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }
}
