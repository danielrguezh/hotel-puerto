package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.mapper.nosql.GuestPreferencesMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.repository.jpa.GuestJpaRepository;
import org.docencia.hotel.persistence.repository.nosql.GuestPreferencesRepository;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;

import jakarta.transaction.Transactional;

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

    private final GuestPreferencesMapper preferencesMapper;
    private final GuestPreferencesRepository preferencesRepository;

    public GuestServiceImpl(GuestJpaRepository guestJpaRepository, GuestMapper guestMapper,
            GuestPreferencesMapper preferencesMapper, GuestPreferencesRepository preferencesRepository) {
        this.guestJpaRepository = guestJpaRepository;
        this.guestMapper = guestMapper;
        this.preferencesMapper = preferencesMapper;
        this.preferencesRepository = preferencesRepository;

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
        guestJpaRepository.deleteById(id);
        return !guestJpaRepository.existsById(id);
    }

        @Override
    public GuestPreferences findPreferences(String guestId) {
        return preferencesMapper.toDomain(preferencesRepository.findById(guestId).orElse(null));
    }

    @Override
    @Transactional
    public GuestPreferences savePreference(String guestId, GuestPreferences preferences) {
        if (guestId == null || guestId.isBlank()) {
            return null;
        }
        preferences.setGuestId(guestId);
        return preferencesMapper.toDomain(preferencesRepository.save(preferencesMapper.toDocument(preferences)));
    }

    @Override
    @Transactional
    public Boolean deletePreferences(String guestId) {
        if (preferencesRepository.findById(guestId) == null) {
            return false;
        }
        preferencesRepository.deleteById(guestId);
        return true;
    }
}
