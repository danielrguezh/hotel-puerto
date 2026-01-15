package org.docencia.hotel.web.soap.impl;

import java.util.List;

import org.docencia.hotel.domain.api.RoomDomain;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.web.soap.RoomSoapService;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
/**
 * @author danielrguzh
 * @version 1.0.0
 */
@Service
@WebService(
        endpointInterface = "org.docencia.hotel.web.soap.RoomSoapService",
        targetNamespace = "http://hotel.docencia.org/ws",
        serviceName = "RoomSoapService",
        portName = "RoomSoapPort"
)
public class RoomSoapServiceImpl  implements RoomSoapService{

    private final RoomDomain roomDomain;

    public RoomSoapServiceImpl(RoomDomain roomDomain) {
        this.roomDomain = roomDomain;
    }

    @Override
    public Room getRoomById(String id) {
        return roomDomain.findById(id);
    }

    @Override
    public Room saveRoom(Room room) {
        return roomDomain.save(room);
    }

    @Override
    public List<Room> findAllRooms() {
        return roomDomain.findAll();
    }

    @Override
    public boolean deleteRoomById(String id) {
        return roomDomain.deleteById(id);
    }

}