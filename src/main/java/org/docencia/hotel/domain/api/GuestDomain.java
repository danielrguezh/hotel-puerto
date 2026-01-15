package org.docencia.hotel.domain.api;

import java.util.List;

import org.docencia.hotel.domain.model.Guest;
import org.docencia.hotel.domain.model.GuestPreferences;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
public interface GuestDomain {
    /**
     * Metodo que devulve una lista de todos los huespedes
     * @return Lista de huespedes
     */
    List<Guest> findAll();

    /**
     * Metodo que devuelve un huesped por su identificador
     * @param id unica del huesped
     * @return huesped con ese identificador, null si no existe
     */
    Guest findById(String id);

    /**
     * Metodo que guarda un huesped
     * @param guest huesped a guardar
     * @return huesped guardado
     */
    Guest save(Guest guest);

    /**
     * Metodo que elimina un huesped por su id
     * @param id unica del huesped que se quiere eliminar
     * @return true si se ha eliminado y false si no se ha eliminado
     */
    Boolean deleteById(String id);

    /**
     * Metodo que devuelve las preferencias de un huesped por su id
     * @param guestId id unica del huesped
     * @return preferencias del huesped
     */
    GuestPreferences findPreferences(String guestId);

    /**
     * Metodo que guarda las preferencias de un huesped por su identificador
     * @param guestId id del huesped
     * @param preferences preferencias del huespred
     * @return preferencias guardadas
     */
    GuestPreferences savePreference(String guestId, GuestPreferences preferences);

    /**
     * Metodo que elimina las preferencias de un huesped por su id
     * @param guestId id del huesped
     * @return preferencias del huesped
     */
    Boolean deletePreferences(String guestId);
}