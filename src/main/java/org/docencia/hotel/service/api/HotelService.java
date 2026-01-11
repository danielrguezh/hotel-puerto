package org.docencia.hotel.service.api;

import org.docencia.hotel.domain.model.Hotel;

import java.util.List;
/**
 * @author danielrguez
 * @version 1.0.0
 */
public interface HotelService {
    /**
     * Metodo que obtiene todos los hoteles
     * @return lista de hoteles
     */
    public List<Hotel> getAll();
    /**
     * Metodo que obtiene un hotel por su id
     * @param id unica del hotel
     * @return hotel
     */
    public Hotel findById(String id);
    /**
     * Metodo que guarda un hotel
     * @param hotel a guardar
     * @return hotel creado
     */
    public Hotel save(Hotel hotel);
    /**
     * Metodo que borra un hotel por su id
     * @param id del hotel
     * @return true/false
     */
    public boolean deleteById(String id);
}
