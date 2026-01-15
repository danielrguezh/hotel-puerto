
package org.docencia.hotel.persistence.nosql.document;

import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
@Document(collection = "guest_preferences")
public class GuestPreferencesDocument {

    @Id
    private String id;

    @Field("tags")
    private List<String> tags;

    @Field("notes")
    private String notes;

    /**
     * Constructor vacio de la clase
     */
    public GuestPreferencesDocument() {
    }

    /**
     * Constructor con el identificador de la clase
     * @param id id del huesped
     */
    public GuestPreferencesDocument(String id) {
        this.id = id;
    }

    /**
     * Constructor con todos los parametros de la clase
     * @param id id del huesped
     * @param tags etiquetas del huesped
     * @param notes notas del guest
     */
    public GuestPreferencesDocument(String id, List<String> tags, String notes) {
        this.id = id;
        this.tags = tags;
        this.notes = notes;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<String> getTags() {
        return tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((id == null) ? 0 : id.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        GuestPreferencesDocument other = (GuestPreferencesDocument) obj;
        if (id == null) {
            if (other.id != null)
                return false;
        } else if (!id.equals(other.id))
            return false;
        return true;
    }


}
