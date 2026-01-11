package org.docencia.hotel.service.api;

import org.docencia.hotel.domain.model.Booking;

import java.util.List;

/**
 * @author danielrguez
 * @version 1.0.0
 */
public interface BookingService {
    List<Booking> findAll();
    Booking findById(String id);


}
