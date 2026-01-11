package org.docencia.hotel.domain.model;

import jakarta.persistence.Column;
import jakarta.xml.bind.annotation.*;

import java.util.Objects;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
@XmlRootElement(name = "hotel")
@XmlAccessorType(XmlAccessType.FIELD)
public class Hotel {
    private String id;
    private String name;
    private String address;

    /**
     * Constructor vacio
     */
    public Hotel() {
    }

    /**
     * Constructor con id
     * @param id unica del hotel
     */
    public Hotel(String id) {
        this.id = id;
    }

    /**
     * Constructor con propiedades
      * @param id unica del hotel
     * @param name nombre del hotel
     * @param address direccion del hotel
     */
    public Hotel(String id, String name, String address) {
        this.id = id;
        this.name = name;
        this.address = address;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Hotel hotel = (Hotel) o;
        return Objects.equals(id, hotel.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
