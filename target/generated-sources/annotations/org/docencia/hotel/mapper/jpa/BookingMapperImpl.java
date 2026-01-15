package org.docencia.hotel.mapper.jpa;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.docencia.hotel.domain.model.Booking;
import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;
import org.docencia.hotel.domain.model.Hotel;
import org.docencia.hotel.domain.model.Room;
import org.docencia.hotel.persistence.jpa.entity.BookingEntity;
import org.docencia.hotel.persistence.jpa.entity.GuestEntity;
import org.docencia.hotel.persistence.jpa.entity.HotelEntity;
import org.docencia.hotel.persistence.jpa.entity.RoomEntity;
import org.docencia.hotel.persistence.nosql.document.GuestPreferencesDocument;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2026-01-15T19:52:41+0000",
    comments = "version: 1.5.5.Final, compiler: Eclipse JDT (IDE) 3.45.0.v20260101-2150, environment: Java 21.0.9 (Eclipse Adoptium)"
)
@Component
public class BookingMapperImpl implements BookingMapper {

    @Override
    public BookingEntity toEntity(Booking domain) {
        if ( domain == null ) {
            return null;
        }

        BookingEntity bookingEntity = new BookingEntity();

        bookingEntity.setRoomId( roomToRoomEntity( domain.getRoom() ) );
        bookingEntity.setGuestId( guestToGuestEntity( domain.getGuest() ) );
        bookingEntity.setId( domain.getId() );
        bookingEntity.setCheckIn( domain.getCheckIn() );
        bookingEntity.setCheckOut( domain.getCheckOut() );

        return bookingEntity;
    }

    @Override
    public Booking toDomain(BookingEntity entity) {
        if ( entity == null ) {
            return null;
        }

        Booking booking = new Booking();

        booking.setRoom( roomEntityToRoom( entity.getRoomId() ) );
        booking.setGuest( guestEntityToGuest( entity.getGuestId() ) );
        booking.setId( entity.getId() );
        booking.setCheckIn( entity.getCheckIn() );
        booking.setCheckOut( entity.getCheckOut() );

        return booking;
    }

    @Override
    public List<Booking> toBookings(List<BookingEntity> entities) {
        if ( entities == null ) {
            return null;
        }

        List<Booking> list = new ArrayList<Booking>( entities.size() );
        for ( BookingEntity bookingEntity : entities ) {
            list.add( toDomain( bookingEntity ) );
        }

        return list;
    }

    protected HotelEntity hotelToHotelEntity(Hotel hotel) {
        if ( hotel == null ) {
            return null;
        }

        HotelEntity hotelEntity = new HotelEntity();

        hotelEntity.setId( hotel.getId() );
        hotelEntity.setName( hotel.getName() );
        hotelEntity.setAddress( hotel.getAddress() );

        return hotelEntity;
    }

    protected Set<BookingEntity> bookingSetToBookingEntitySet(Set<Booking> set) {
        if ( set == null ) {
            return null;
        }

        Set<BookingEntity> set1 = new LinkedHashSet<BookingEntity>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( Booking booking : set ) {
            set1.add( toEntity( booking ) );
        }

        return set1;
    }

    protected RoomEntity roomToRoomEntity(Room room) {
        if ( room == null ) {
            return null;
        }

        RoomEntity roomEntity = new RoomEntity();

        roomEntity.setId( room.getId() );
        roomEntity.setNumber( room.getNumber() );
        roomEntity.setType( room.getType() );
        roomEntity.setPricePerNight( room.getPricePerNight() );
        roomEntity.setHotel( hotelToHotelEntity( room.getHotel() ) );
        roomEntity.setBookings( bookingSetToBookingEntitySet( room.getBookings() ) );

        return roomEntity;
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

    protected GuestEntity guestToGuestEntity(Guest guest) {
        if ( guest == null ) {
            return null;
        }

        GuestEntity guestEntity = new GuestEntity();

        guestEntity.setId( guest.getId() );
        guestEntity.setFullName( guest.getFullName() );
        guestEntity.setEmail( guest.getEmail() );
        guestEntity.setPhone( guest.getPhone() );
        guestEntity.setPreference( guestPreferencesToGuestPreferencesDocument( guest.getPreference() ) );

        return guestEntity;
    }

    protected Hotel hotelEntityToHotel(HotelEntity hotelEntity) {
        if ( hotelEntity == null ) {
            return null;
        }

        Hotel hotel = new Hotel();

        hotel.setId( hotelEntity.getId() );
        hotel.setName( hotelEntity.getName() );
        hotel.setAddress( hotelEntity.getAddress() );

        return hotel;
    }

    protected Set<Booking> bookingEntitySetToBookingSet(Set<BookingEntity> set) {
        if ( set == null ) {
            return null;
        }

        Set<Booking> set1 = new LinkedHashSet<Booking>( Math.max( (int) ( set.size() / .75f ) + 1, 16 ) );
        for ( BookingEntity bookingEntity : set ) {
            set1.add( toDomain( bookingEntity ) );
        }

        return set1;
    }

    protected Room roomEntityToRoom(RoomEntity roomEntity) {
        if ( roomEntity == null ) {
            return null;
        }

        Room room = new Room();

        room.setId( roomEntity.getId() );
        room.setNumber( roomEntity.getNumber() );
        room.setType( roomEntity.getType() );
        room.setPricePerNight( roomEntity.getPricePerNight() );
        room.setHotel( hotelEntityToHotel( roomEntity.getHotel() ) );
        room.setBookings( bookingEntitySetToBookingSet( roomEntity.getBookings() ) );

        return room;
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

    protected Guest guestEntityToGuest(GuestEntity guestEntity) {
        if ( guestEntity == null ) {
            return null;
        }

        Guest guest = new Guest();

        guest.setId( guestEntity.getId() );
        guest.setFullName( guestEntity.getFullName() );
        guest.setEmail( guestEntity.getEmail() );
        guest.setPhone( guestEntity.getPhone() );
        guest.setPreference( guestPreferencesDocumentToGuestPreferences( guestEntity.getPreference() ) );

        return guest;
    }
}
