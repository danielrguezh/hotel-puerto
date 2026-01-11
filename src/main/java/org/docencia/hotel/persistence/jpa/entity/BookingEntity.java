package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * @author danielrguez
 * @version 1.0.0
 */
@Entity
@Table(name = "booking")
public class BookingEntity {
    // TODO: @Id + campos + relaciones
    @Id
    private String id;
    //    room_id TEXT NOT NULL,
    //    guest_id TEXT NOT NULL,
    //    check_in TEXT,
    //    check_out TEXT,
    //    FOREIGN KEY (room_id) REFERENCES room(id),
    //    FOREIGN KEY (guest_id) REFERENCES guest(id)
}
