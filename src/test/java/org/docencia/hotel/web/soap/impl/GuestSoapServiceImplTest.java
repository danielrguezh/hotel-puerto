package org.docencia.hotel.web.soap.impl;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Set;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.web.soap.GuestSoapServiceImpl;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

@ExtendWith(MockitoExtension.class)
class GuestSoapServiceImplTest {

    @Mock
    private GuestDomain guestDomain;

    @InjectMocks
    private GuestSoapServiceImpl guestSoapService;

    @Test
    void getGuestByIdTestReturnGuest() {
        Long id = 1L;
        Guest guest = new Guest();
        when(guestDomain.findById(id)).thenReturn(guest);

        Guest result = guestSoapService.getGuestById(id);

        assertEquals(guest, result);
    }

    @Test
    void saveGuestTestReturnGuest() {
        Guest guest = new Guest();
        when(guestDomain.save(guest)).thenReturn(guest);

        Guest result = guestSoapService.saveGuest(guest);

        assertEquals(guest, result);
    }
}