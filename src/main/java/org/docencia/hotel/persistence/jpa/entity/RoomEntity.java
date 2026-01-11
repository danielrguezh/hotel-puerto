package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * @author danielrguez
 * @version 1.0.0
 */
@Entity
@Table(name = "room")
public class RoomEntity {
    @Id
    private String id;
    @Column(name = "number", nullable = false)
    private String number;
    @Column(name = "type")
    private String type;
    @Column(name = "price_per_night")
    private float pricePerNight;

    //    hotel_id TEXT NOT NULL,
    //    FOREIGN KEY (hotel_id) REFERENCES hotel(id)
}
