package org.docencia.hotel.mapper.jpa;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-15T19:52:41+0000",
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
        guestEntity.setPreference( guestPreferencesToGuestPreferencesDocument( domain.getPreference() ) );

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
        guest.setPreference( guestPreferencesDocumentToGuestPreferences( entity.getPreference() ) );

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

    protected GuestPreferencesDocument guestPreferencesToGuestPreferencesDocument(GuestPreferences guestPreferences) {
        if ( guestPreferences == null ) {
            return null;
        }

        GuestPreferencesDocument guestPreferencesDocument = new GuestPreferencesDocument();

        List<String> list = guestPreferences.getTags();
        if ( list != null ) {
            guestPreferencesDocument.setTags( new ArrayList<String>( list ) );
        }
        guestPreferencesDocument.setNotes( guestPreferences.getNotes() );

        return guestPreferencesDocument;
    }

    protected GuestPreferences guestPreferencesDocumentToGuestPreferences(GuestPreferencesDocument guestPreferencesDocument) {
        if ( guestPreferencesDocument == null ) {
            return null;
        }

        GuestPreferences guestPreferences = new GuestPreferences();

        List<String> list = guestPreferencesDocument.getTags();
        if ( list != null ) {
            guestPreferences.setTags( new ArrayList<String>( list ) );
        }
        guestPreferences.setNotes( guestPreferencesDocument.getNotes() );

        return guestPreferences;
    }
}
