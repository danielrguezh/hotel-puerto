package org.docencia.hotel.mapper.jpa;

import org.mapstruct.Mapper;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;

import java.util.List;

@Mapper(componentModel = "spring")
public interface BookingMapper {
    BookingEntity toEntity(Booking domain);
    Booking toDomain(BookingEntity entity);
    List<Booking> toBookings(List<BookingEntity> entities);
}
