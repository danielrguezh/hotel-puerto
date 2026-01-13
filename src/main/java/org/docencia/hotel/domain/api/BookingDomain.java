package org.docencia.hotel.domain.api;

import java.util.List;

import org.docencia.hotel.domain.model.Booking;
/**
 * @author danielerguezh
 * @version 1.0.0
 */
public interface BookingDomain {

    /**
     * Metodo que devulve una lista de todas las reservas
     * @return Lista de reservas
     */
    List<Booking> findAll();

    /**
     * Metodo que devuelve una reserva por su identificador
     * @param id unica de la reserva
     * @return la reserva con ese identificador, null si no existe
     */
    Booking findById(String id);

    /**
     * Metodo que guarda una reserva
     * @param booking reserva que se quiere guardar
     * @return reserva guardada
     */
    Booking save(Booking booking);

    /**
     * Metodo que elimina una reserva por su id
     * @param id unica de la reserva que se quiere eliminar
     * @return true si se ha eliminado y false si no se ha eliminado
     */
    Boolean deleteById(String id);
}