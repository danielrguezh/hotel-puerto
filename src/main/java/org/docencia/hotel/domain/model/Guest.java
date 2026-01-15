package org.docencia.hotel.domain.model;

import jakarta.persistence.Column;
import jakarta.persistence.Id;
import jakarta.xml.bind.annotation.*;

import java.util.Objects;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
public class Guest {
    private String id;
    private String fullName;
    private String email;
    private  String phone;
    private GuestPreferences preference;

    /**
     * Constructor vacio
     */
    public Guest() {
    }

    /**
     * Constructor con id
     * @param id unica del huesped
     */
    public Guest(String id) {
        this.id = id;
    }

    /**
     * Constructor con propiedades
     * @param id unica del huesped
     * @param fullName nombre del huesped
     * @param email del huesped
     * @param phone telefono del huesped
     * @param preference preferencias del huesped
     */
    public Guest(String id, String fullName, String email, String phone,  GuestPreferences preference) {
        this.id = id;
        this.fullName = fullName;
        this.email = email;
        this.phone = phone;
        this.preference = preference;
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

    public GuestPreferences getPreference() {
        return this.preference;
    }

    public void setPreference(GuestPreferences preference) {
        this.preference = preference;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Guest guest = (Guest) o;
        return Objects.equals(id, guest.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
