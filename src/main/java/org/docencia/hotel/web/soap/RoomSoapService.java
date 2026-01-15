package org.docencia.hotel.web.soap;

import java.util.List;

import org.docencia.hotel.domain.model.Room;

import jakarta.jws.WebMethod;
import jakarta.jws.WebParam;
import jakarta.jws.WebResult;
import jakarta.jws.WebService;
/**
 * @author danielrguezh
 * @version 1.0.0
 */
@WebService(
        name = "RoomSoapService",
        targetNamespace = "http://hotel.docencia.org/ws"
)
public interface RoomSoapService {
    @WebMethod(operationName = "GetRoomById")
    @WebResult(name = "room")
    Room getRoomById(@WebParam(name = "id") String id);

    @WebMethod(operationName = "SaveRoom")
    @WebResult(name = "room")
    Room saveRoom(@WebParam(name = "room") Room room);

    @WebMethod(operationName = "FindAllRooms")
    @WebResult(name = "rooms")
    List<Room> findAllRooms();

    @WebMethod(operationName = "DeleteRoomById")
    @WebResult(name = "success")
    boolean deleteRoomById(@WebParam(name = "id") String id);
}