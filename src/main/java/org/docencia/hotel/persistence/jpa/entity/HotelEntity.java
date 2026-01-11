package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * @author danielrguez
 * @version 1.0.0
 */
@Entity
@Table(name = "hotel")
public class HotelEntity {
    @Id
    private String id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "address")
    private String address;

    /**
     * Constructor vacio
     */
    public HotelEntity() {
    }

    /**
     * Constructor con id
     * @param id unica
     */
    public HotelEntity(String id) {
        this.id = id;
    }

    /**
     * Constructor con propiedades
     * @param id unica
     * @param name nombre del hotel
     * @param address direccion del hotel
     */
    public HotelEntity(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return this.address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof HotelEntity)) {
            return false;
        }
        HotelEntity hotelEntity = (HotelEntity) o;
        return Objects.equals(id, hotelEntity.id) ;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
