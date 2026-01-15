package org.docencia.hotel.domain.impl;

import java.util.List;
import java.util.Set;

import org.docencia.hotel.domain.api.HotelDomain;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.service.api.HotelService;
import org.springframework.stereotype.Service;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
@Service
public class HotelDomainImpl implements HotelDomain {

    private final HotelService service;

    public HotelDomainImpl(HotelService service) {
        this.service = service;
    }

    @Override
    public List<Hotel> findAll() {
        return service.getAll();
    }

    @Override
    public Hotel findById(String id) {
        return service.findById(id);
    }

    @Override
    public Hotel save(Hotel hotel) {
        return service.save(hotel);
    }

    @Override
    public Boolean deleteById(String id) {
        return service.deleteById(id);
    }

}