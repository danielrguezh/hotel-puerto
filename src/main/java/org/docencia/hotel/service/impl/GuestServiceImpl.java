package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.repository.jpa.GuestJpaRepository;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @author danielrguez
 * @version 1.0.0
 */
@Service
public class GuestServiceImpl implements GuestService {
    private final GuestJpaRepository guestJpaRepository;
    private final GuestMapper guestMapper;

    public GuestServiceImpl(GuestJpaRepository guestJpaRepository, GuestMapper guestMapper) {
        this.guestJpaRepository = guestJpaRepository;
        this.guestMapper = guestMapper;
    }

    @Override
    public List<Guest> getAll() {
        List<Guest> guests =new ArrayList<>();
        if (guestJpaRepository.count() >0) {
            guests = guestMapper.toGuests(guestJpaRepository.findAll());
        }

        return guests;
    }

    @Override
    public Guest findById(String id) {
        return guestMapper.toDomain(guestJpaRepository.findById(id).orElse(null));
    }

    @Override
    public Guest save(Guest guest) {
        if (guest.getId() == null) {
            List<GuestEntity> guests = guestJpaRepository.findAll();
            if (guests.isEmpty()) {
                guest.setId("G1");
            } else {
                GuestEntity last = guests.get(guests.size() - 1);
                int newId = Integer.parseInt(last.getId().replace("G", "")) + 1;
                guest.setId("G" + newId);
            }
        }
        return guestMapper.toDomain(guestJpaRepository.save(guestMapper.toEntity(guest)));
    }

    @Override
    public boolean deleteById(String id) {
        return guestJpaRepository.existsById(id);
    }
}
