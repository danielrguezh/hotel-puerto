package org.docencia.hotel.service.impl;


import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.mapper.jpa.RoomMapper;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.repository.jpa.RoomRepository;
import org.docencia.hotel.service.api.RoomService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RoomServiceImpl implements RoomService {
    private final RoomRepository repository;
    private final RoomMapper mapper;

    public RoomServiceImpl(RoomRepository repository, RoomMapper mapper) {
        this.repository = repository;
        this.mapper = mapper;
    }

    @Override
    public List<Room> findAll() {
        List<Room> rooms =new ArrayList<>();
        if (repository.count() >0) {
            rooms = mapper.toRooms(repository.findAll());
        }

        return rooms;
    }

    @Override
    public Room findById(String id) {
        return mapper.toDomain(repository.findById(id).orElse(null));
    }

    @Override
    public Room save(Room room) {
        if (room.getId() == null) {
            List<RoomEntity> rooms = repository .findAll();
            if (rooms.isEmpty()) {
                room.setId("R1");
            } else {
                RoomEntity last = rooms.get(rooms.size() - 1);
                int newId = Integer.parseInt(last.getId().replace("R", "")) + 1;
                room.setId("R" + newId);
            }
        }
        return mapper.toDomain(repository.save(mapper.toEntity(room)));
    }

    @Override
    public boolean deleteById(String id) {
        repository.deleteById(id);
        return !repository.existsById(id);
    }

    @Override
    public List<Room> findByHotelId(String hotelId) {
        return mapper.toRooms(repository.findAllByHotelId(hotelId));
    }
}
