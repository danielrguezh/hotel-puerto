package org.docencia.hotel.web.soap.impl;

import java.util.List;

import org.docencia.hotel.domain.api.HotelDomain;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.web.soap.HotelSoapService;
import org.springframework.stereotype.Service;

import jakarta.jws.WebService;
/**
 * @author danielrguezh
 * @version 1.0.0
 */
@Service
@WebService(
        endpointInterface = "org.docencia.hotel.web.soap.HotelSoapService",
        targetNamespace = "http://hotel.docencia.org/ws",
        serviceName = "HotelSoapService",
        portName = "HotelSoapPort"
)
public class HotelSoapServiceImpl implements HotelSoapService {

    private final HotelDomain hotelDomain;

    public HotelSoapServiceImpl(HotelDomain hotelDomain) {
        this.hotelDomain = hotelDomain;
    }

    @Override
    public Hotel getHotelById(String id) {
        return hotelDomain.findById(id);
    }

    @Override
    public Hotel saveHotel(Hotel hotel) {
        return hotelDomain.save(hotel);
    }

    @Override
    public List<Hotel> findAllHotels() {
        return hotelDomain.findAll();
    }

    @Override
    public boolean deleteHotelById(String id) {
        return hotelDomain.deleteById(id);
    }

}