package org.docencia.hotel.service.api;

import org.docencia.hotel.domain.model.Guest;

import java.util.List;

/**
 * @author danielrguez
 * @version 1.0.0
 */
public interface GuestService {
    /**
     * Metodo que obtiene todos los huespedes
     * @return lista de huespedes
     */
    public List<Guest> getAll();

    /**
     * Metodo que obtiene un huesped por su id
     * @param id unica del huesped
     * @return huesped
     */
    public Guest findById(String id);

    /**
     * Metodo que guarda un huesped
     * @param guest huesped a guardar
     * @return huesped creado
     */
    public Guest save(Guest guest);

    /**
     * Metodo que borra un huesped por su id
     * @param id del huesped
     * @return true/false
     */
    public boolean deleteById(String id);
}