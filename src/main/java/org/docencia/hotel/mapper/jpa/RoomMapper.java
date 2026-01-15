package org.docencia.hotel.mapper.jpa;

import org.mapstruct.*;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RoomMapper {
    @Mapping(target = "hotel", source = "hotel")
    @Mapping(target = "bookings", ignore = true)
    RoomEntity toEntity(Room domain);
    
    @Mapping(target = "hotel", source = "hotel")
    @Mapping(target = "bookings", ignore = true)
    Room toDomain(RoomEntity entity);

    List<Room> toRooms(List<RoomEntity> all);
}
