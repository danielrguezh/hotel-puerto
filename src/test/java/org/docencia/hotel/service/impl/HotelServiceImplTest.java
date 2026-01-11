package org.docencia.hotel.service.impl;

import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.mapper.jpa.HotelMapper;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.repository.jpa.HotelRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class HotelServiceImplTest {

    @Mock
    private HotelRepository hotelRepository;

    @Mock
    private HotelMapper hotelMapper;

    @InjectMocks
    private HotelServiceImpl hotelService;

    private HotelEntity hotelEntity;
    private Hotel hotel;

    @BeforeEach
    void setUp() {
        hotelEntity = new HotelEntity();
        hotelEntity.setId("H1");
        hotelEntity.setName("Hotel Puerto");
        hotelEntity.setAddress("Calle Mar 1");

        hotel = new Hotel();
        hotel.setId("H1");
        hotel.setName("Hotel Puerto");
        hotel.setAddress("Calle Mar 1");
    }

    // -------------------- getAll --------------------

    @Test
    void getAll_whenThereAreHotels_returnsHotelList() {
        when(hotelRepository.count()).thenReturn(1L);
        when(hotelRepository.findAll()).thenReturn(List.of(hotelEntity));
        when(hotelMapper.toHotels(anyList())).thenReturn(List.of(hotel));

        List<Hotel> result = hotelService.getAll();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Hotel Puerto", result.get(0).getName());

        verify(hotelRepository).findAll();
        verify(hotelMapper).toHotels(anyList());
    }

    @Test
    void getAll_whenNoHotels_returnsEmptyList() {
        when(hotelRepository.count()).thenReturn(0L);

        List<Hotel> result = hotelService.getAll();

        assertNotNull(result);
        assertTrue(result.isEmpty());

        verify(hotelRepository, never()).findAll();
        verify(hotelMapper, never()).toHotels(anyList());
    }

    // -------------------- findById --------------------

    @Test
    void findById_whenHotelExists_returnsHotel() {
        when(hotelRepository.findById("H1")).thenReturn(Optional.of(hotelEntity));
        when(hotelMapper.toDomain(hotelEntity)).thenReturn(hotel);

        Hotel result = hotelService.findById("H1");

        assertNotNull(result);
        assertEquals("H1", result.getId());
        assertEquals("Hotel Puerto", result.getName());
    }

    @Test
    void findById_whenHotelDoesNotExist_returnsNull() {
        when(hotelRepository.findById("H1")).thenReturn(Optional.empty());
        when(hotelMapper.toDomain(null)).thenReturn(null);

        Hotel result = hotelService.findById("H1");

        assertNull(result);
    }

    // -------------------- save --------------------

    @Test
    void save_savesHotelSuccessfully() {
        when(hotelMapper.toEntity(hotel)).thenReturn(hotelEntity);
        when(hotelRepository.save(hotelEntity)).thenReturn(hotelEntity);
        when(hotelMapper.toDomain(hotelEntity)).thenReturn(hotel);

        Hotel result = hotelService.save(hotel);

        assertNotNull(result);
        assertEquals("H1", result.getId());

        verify(hotelRepository).save(hotelEntity);
    }

    // -------------------- deleteById --------------------

    @Test
    void deleteById_whenHotelExists_returnsTrue() {
        when(hotelRepository.existsById("H1")).thenReturn(true);

        boolean result = hotelService.deleteById("H1");

        assertTrue(result);
        verify(hotelRepository).existsById("H1");
    }

    @Test
    void deleteById_whenHotelDoesNotExist_returnsFalse() {
        when(hotelRepository.existsById("H1")).thenReturn(false);

        boolean result = hotelService.deleteById("H1");

        assertFalse(result);
    }
}

