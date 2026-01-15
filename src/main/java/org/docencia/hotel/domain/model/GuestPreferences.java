package org.docencia.hotel.domain.model;

import java.util.List;
import java.util.Objects;

/**
 * @author danielrguez
 * @version 1.0.0
 */
public class GuestPreferences {
    private String guestId;
    private List<String> tags;
    private String notes;

    /**
     * Constructor vacio
     */
    public GuestPreferences() {
    }

    /**
     * Constructor con el identificador de la clase
     * @param guestId id unica del huesped
     */
    public GuestPreferences(String guestId) {
        this.guestId = guestId;
    }

    /**
     * Constructor con todos los parametros de la clase
     * @param guestId id del huesped
     * @param tags etiquetas del huesped
     * @param notes notas del guest
     */
    public GuestPreferences(String guestId, List<String> tags, String notes) {
        this.guestId = guestId;
        this.tags = tags;
        this.notes = notes;
    }

    public String getGuestId() {
        return this.guestId;
    }

    public void setGuestId(String guestId) {
        this.guestId = guestId;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getNotes() {
        return this.notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (!(o instanceof GuestPreferences)) {
            return false;
        }
        GuestPreferences guestPreferences = (GuestPreferences) o;
        return Objects.equals(guestId, guestPreferences.guestId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(guestId);
    }
}