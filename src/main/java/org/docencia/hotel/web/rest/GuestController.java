package org.docencia.hotel.web.rest;

import org.docencia.hotel.domain.api.GuestDomain;
import org.docencia.hotel.domain.model.Guest;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Tag(name = "Guests", description = "Operaciones REST de huéspedes")
@RestController
@RequestMapping("/api/guests")
public class GuestController {

    private final GuestDomain guestDomain;

    public GuestController(GuestDomain guestDomain) {
        this.guestDomain = guestDomain;
    }

    @Operation(summary = "Obtener huésped por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "Huesped no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Guest> findById(@PathVariable Long id) {
        Guest guest = guestDomain.findById(id);
        if (guest == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(guest);
    }

    @Operation(summary = "Guardar huésped")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Huesped creado correctamente"),
            @ApiResponse(responseCode = "400", description = "No se pudo guardar el huesped")
    })
    @PostMapping("/add")
    public ResponseEntity<Guest> save(@Valid @RequestBody Guest guest) {
        Guest guestSaved = guestDomain.save(guest);
        if (guestSaved == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(guestSaved);
    }
}
