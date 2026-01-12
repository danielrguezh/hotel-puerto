package org.docencia.hotel.mapper.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-12T15:27:51+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class GuestMapperImpl implements GuestMapper {

    @Override
    public GuestEntity toEntity(Guest domain) {
        if ( domain == null ) {
            return null;
        }

        GuestEntity guestEntity = new GuestEntity();

        guestEntity.setId( domain.getId() );
        guestEntity.setFullName( domain.getFullName() );
        guestEntity.setEmail( domain.getEmail() );
        guestEntity.setPhone( domain.getPhone() );

        return guestEntity;
    }

    @Override
    public Guest toDomain(GuestEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setId( entity.getId() );
        guest.setFullName( entity.getFullName() );
        guest.setEmail( entity.getEmail() );
        guest.setPhone( entity.getPhone() );

        return guest;
    }

    @Override
    public List<Guest> toGuests(List<GuestEntity> guestEntities) {
        if ( guestEntities == null ) {
            return null;
        }

        List<Guest> list = new ArrayList<Guest>( guestEntities.size() );
        for ( GuestEntity guestEntity : guestEntities ) {
            list.add( toDomain( guestEntity ) );
        }

        return list;
    }
}
