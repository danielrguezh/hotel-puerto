package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.mapper.jpa.GuestMapper;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.repository.jpa.GuestJpaRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class GuestServiceImplTest {

    @Mock
    private GuestJpaRepository guestJpaRepository;

    @Mock
    private GuestMapper guestMapper;

    @InjectMocks
    private GuestServiceImpl guestService;

    private GuestEntity guestEntity1;
    private GuestEntity guestEntity2;
    private Guest guest1;
    private Guest guest2;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);

        guestEntity1 = new GuestEntity("G1", "Ana Lopez", "ana@example.com", "+34 600 111 222");
        guestEntity2 = new GuestEntity("G2", "Carlos Perez", "carlos@example.com", "+34 600 333 444");

        guest1 = new Guest("G1", "Ana Lopez", "ana@example.com", "+34 600 111 222");
        guest2 = new Guest("G2", "Carlos Perez", "carlos@example.com", "+34 600 333 444");
    }

    @Test
    void testGetAll() {
        when(guestJpaRepository.count()).thenReturn(2L);
        when(guestJpaRepository.findAll()).thenReturn(Arrays.asList(guestEntity1, guestEntity2));
        when(guestMapper.toGuests(anyList())).thenReturn(Arrays.asList(guest1, guest2));

        List<Guest> guests = guestService.getAll();

        assertEquals(2, guests.size());
        assertEquals("Ana Lopez", guests.get(0).getFullName());
        assertEquals("Carlos Perez", guests.get(1).getFullName());
    }

    @Test
    void testFindById() {
        when(guestJpaRepository.findById("G1")).thenReturn(Optional.of(guestEntity1));
        when(guestMapper.toDomain(guestEntity1)).thenReturn(guest1);

        Guest found = guestService.findById("G1");

        assertNotNull(found);
        assertEquals("Ana Lopez", found.getFullName());
    }

    @Test
    void testSaveNewGuest_WhenEmpty() {
        Guest newGuest = new Guest(null, "Luis Gomez", "luis@example.com", "+34 600 555 666");
        GuestEntity newGuestEntity = new GuestEntity(null, "Luis Gomez", "luis@example.com", "+34 600 555 666");
        Guest savedGuest = new Guest("G1", "Luis Gomez", "luis@example.com", "+34 600 555 666");

        when(guestJpaRepository.findAll()).thenReturn(List.of());
        when(guestMapper.toEntity(newGuest)).thenReturn(newGuestEntity);
        when(guestJpaRepository.save(newGuestEntity)).thenReturn(new GuestEntity("G1", "Luis Gomez", "luis@example.com", "+34 600 555 666"));
        when(guestMapper.toDomain(any(GuestEntity.class))).thenReturn(savedGuest);

        Guest result = guestService.save(newGuest);

        assertEquals("G1", result.getId());
        assertEquals("Luis Gomez", result.getFullName());
    }

    @Test
    void testSaveNewGuest_WhenNotEmpty() {
        Guest newGuest = new Guest(null, "Luis Gomez", "luis@example.com", "+34 600 555 666");
        GuestEntity lastEntity = guestEntity2; // último guest existente
        GuestEntity newGuestEntity = new GuestEntity(null, "Luis Gomez", "luis@example.com", "+34 600 555 666");
        Guest savedGuest = new Guest("G3", "Luis Gomez", "luis@example.com", "+34 600 555 666");

        when(guestJpaRepository.findAll()).thenReturn(Arrays.asList(guestEntity1, guestEntity2));
        when(guestMapper.toEntity(newGuest)).thenReturn(newGuestEntity);
        when(guestJpaRepository.save(newGuestEntity)).thenReturn(new GuestEntity("G3", "Luis Gomez", "luis@example.com", "+34 600 555 666"));
        when(guestMapper.toDomain(any(GuestEntity.class))).thenReturn(savedGuest);

        Guest result = guestService.save(newGuest);

        assertEquals("G3", result.getId());
        assertEquals("Luis Gomez", result.getFullName());
    }

    @Test
    void testDeleteById() {
        when(guestJpaRepository.existsById("G1")).thenReturn(true);

        boolean deleted = guestService.deleteById("G1");

        assertTrue(deleted);
    }
}
