package org.docencia.hotel.service.api;

import org.docencia.hotel.domain.model.Booking;

import java.util.List;

/**
 * @author danielrguez
 * @version 1.0.0
 */
public interface BookingService {
    /**
     * Metodo que obtiene todas los reservas
     * @return lista de reservas
     */
    List<Booking> findAll();
    /**
     * Metodo que obtiene una reserva  por su id
     * @param id unica de la reserva
     * @return reserva
     */
    Booking findById(String id);

    /**
     * Metodo que guarda una reserva
     * @param booking reserva a guardar
     * @return reserva creado
     */
    public Booking save(Booking booking);

    /**
     * Metodo que borra una reserva por su id
     * @param id de la reserva
     * @return true/false
     */
    public boolean deleteById(String id);
}
