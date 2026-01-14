package org.docencia.hotel.service.api;

import org.docencia.hotel.domain.model.Room;

import java.util.List;

/**
 * @author danielrguez
 * @version 1.0.0
 */
public interface RoomService{
    /**
     * Metodo que obtiene todas los habitaciones
     * @return lista de habitaciones
     */
    List<Room> findAll();
    /**
     * Metodo que obtiene una habitacion  por su id
     * @param id unica de la habitacion
     * @return habitacion
     */
    Room findById(String id);

    /**
     * Metodo que guarda una habitacion
     * @param room habitacion a guardar
     * @return habitacion creado
     */
    public Room save(Room room);

    /**
     * Metodo que borra una habitacion por su id
     * @param id unica de la habitacion
     * @return true/false
     */
    public boolean deleteById(String id);

    /**
     * Metodo que devuelve una habitacion por el id de hotel
     * @param hotelId unica
     * @return habitaciones del hotel
     */
    List<Room> findByHotelId(String hotelId);
}
