package org.docencia.hotel.domain.impl;

import java.util.List;
import java.util.Set;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.service.api.GuestService;
import org.springframework.stereotype.Service;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
@Service
public class GuestDomainImpl implements GuestDomain {

    private final GuestService service;

    public GuestDomainImpl(GuestService service) {
        this.service = service;
    }

    @Override
    public List<Guest> findAll() {
        return service.getAll();
    }

    @Override
    public Guest findById(String id) {
        return service.findById(id);
    }

    @Override
    public Guest save(Guest guest) {
        return service.save(guest);
    }

    @Override
    public Boolean deleteById(String id) {
        return service.deleteById(id);
    }

    @Override
    public GuestPreferences findPreferences(String guestId) {
        return service.findPreferences(guestId);
    }

    @Override
    public GuestPreferences savePreference(String guestId, GuestPreferences preferences) {
        return service.savePreference(guestId, preferences);
    }

    @Override
    public Boolean deletePreferences(String guestId) {
        return service.deletePreferences(guestId);
    }
}