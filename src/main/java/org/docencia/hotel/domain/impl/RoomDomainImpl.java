package org.docencia.hotel.domain.impl;

import java.util.List;

import org.docencia.hotel.domain.api.RoomDomain;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
@Service
public class RoomDomainImpl implements RoomDomain {

    private final RoomService service;

    public RoomDomainImpl(RoomService service) {
        this.service = service;
    }

    @Override
    public List<Room> findAll() {
        return service.findAll();
    }

    @Override
    public Room findById(String id) {
        return service.findById(id);
    }

    @Override
    public Room save(Room room) {
        return service.save(room);
    }

    @Override
    public Boolean deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public List<Room> findByHotelId(String hotelId) {
        return service.findByHotelId(hotelId);
    }
}