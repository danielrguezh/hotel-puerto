package org.docencia.hotel.persistence.jpa.entity;

import jakarta.persistence.*;
import java.util.Objects;

/**
 * @author danielrguez
 * @version 1.0.0
 */
@Entity
@Table(name = "guest")
public class GuestEntity {
    @Id
    private String id;
    @Column(name = "full_name", nullable = false)
    private String fullName;
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private  String phone;

    /**
     * Constructor vacio
     */
    public GuestEntity() {
    }

    /**
     * Constructor con id
     * @param id unica
     */
    public GuestEntity(String id) {
        this.id = id;
    }

    /**
     * Constructor con propiedades
     * @param id unica
     * @param fullName nombre del huesped
     * @param email del huesped
     * @param phone telefono del huesped
     */
    public GuestEntity(String id, String fullName, String email, String phone) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GuestEntity that = (GuestEntity) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
