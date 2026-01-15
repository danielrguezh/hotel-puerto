package org.docencia.hotel.persistence.repository.jpa;

import java.util.List;

import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author danielrguez
 * @version 1.0.0
 */
@Repository
public interface RoomRepository  extends JpaRepository<RoomEntity,String> {
    /**
     * Metodo que retorna las habitaciones de un hotel concreto
     * @param hotelId unica del hotel
     * @return habitaciones del hotel
     */
    List<RoomEntity> findAllByHotelId(String hotelId);
}
