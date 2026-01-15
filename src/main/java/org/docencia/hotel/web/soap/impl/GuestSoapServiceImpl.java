package org.docencia.hotel.web.soap.impl;

import java.util.List;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.web.soap.GuestSoapService;

import jakarta.jws.WebService;
import org.springframework.stereotype.Service;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
@Service
@WebService(
        endpointInterface = "org.docencia.hotel.web.soap.GuestSoapService",
        targetNamespace = "http://hotel.docencia.org/ws",
        serviceName = "GuestSoapService",
        portName = "GuestSoapPort"
)
public class GuestSoapServiceImpl implements GuestSoapService {

    private final GuestDomain guestDomain;

    public GuestSoapServiceImpl(GuestDomain guestDomain) {
        this.guestDomain = guestDomain;
    }

    @Override
    public Guest getGuestById(String id) {
        return guestDomain.findById(id);
    }

    @Override
    public Guest saveGuest(Guest guest) {
        return  guestDomain.save(guest);
    }

    @Override
    public List<Guest> findAllGuests() {
        return guestDomain.findAll();
    }

    @Override
    public boolean deleteGuestById(String id) {
        return guestDomain.deleteById(id);
    }
    
    @Override
    public GuestPreferences findPreferenceById(String guestId) {
        return guestDomain.findPreferences(guestId);
    }

    @Override
    public GuestPreferences saveGuestPreferences(String guestId, GuestPreferences preferences) {
        if (findPreferenceById(guestId) == null) {
            return null;
        }
        return guestDomain.savePreference(guestId, preferences);
    }

    @Override
    public boolean deletePreferenceById(String guestId) {
        return guestDomain.deletePreferences(guestId);
    }

}