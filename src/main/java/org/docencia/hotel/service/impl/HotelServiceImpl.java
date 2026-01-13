package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.mapper.jpa.HotelMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.repository.jpa.HotelRepository;
import org.docencia.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelServiceImpl implements HotelService {
    private final HotelRepository hotelRepository;
    private final HotelMapper hotelMapper;

    public HotelServiceImpl(HotelRepository hotelRepository, HotelMapper hotelMapper) {
        this.hotelRepository = hotelRepository;
        this.hotelMapper = hotelMapper;
    }

    @Override
    public List<Hotel> getAll() {
        List<Hotel> hotels = new ArrayList<>();
        if (hotelRepository.count() >0) {
            hotels = hotelMapper.toHotels(hotelRepository.findAll());
        }

        return hotels;
    }

    @Override
    public Hotel findById(String id) {
        return hotelMapper.toDomain(hotelRepository.findById(id).orElse(null));
    }

    @Override
    public Hotel save(Hotel hotel) {
        if (hotel.getId() == null){
            List<HotelEntity> hotels = hotelRepository.findAll();
            if (hotels.isEmpty()) {
                hotel.setId("H1");
            } else {
                HotelEntity last = hotels.get(hotels.size() - 1);
                int newId = Integer.parseInt(last.getId().replace("H", "")) + 1;
                hotel.setId("H" + newId);
            }
        }
        return hotelMapper.toDomain(hotelRepository.save(hotelMapper.toEntity(hotel)));

    }

    @Override
    public boolean deleteById(String id) {
        hotelRepository.deleteById(id);
        return !hotelRepository.existsById(id);
    }
}
