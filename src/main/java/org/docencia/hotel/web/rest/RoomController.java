package org.docencia.hotel.web.rest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.docencia.hotel.domain.api.RoomDomain;
import org.docencia.hotel.domain.model.Room;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.Valid;

/**
 * @author danielrguezh
 * @version 1.0.0
 */
@Tag(name = "Rooms", description = "Operaciones REST de habitaciones")
@RestController
@RequestMapping("/api/rooms")
public class RoomController {
    private final RoomDomain roomDomain;

    public RoomController(RoomDomain roomDomain) {
        this.roomDomain = roomDomain;
    }

    @Operation(summary = "Obtener habitacion por id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "OK"),
            @ApiResponse(responseCode = "404", description = "habitacion no encontrado")
    })
    @GetMapping("/{id}")
    public ResponseEntity<Room> findById(@PathVariable String id) {
        Room room = roomDomain.findById(id);
        if (room == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(room);
    }

    @Operation(summary = "Guardar habitacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "habitacion creada correctamente"),
            @ApiResponse(responseCode = "400", description = "No se pudo guardar la habitacion")
    })
    @PostMapping("/add")
    public ResponseEntity<Room> save(@Valid @RequestBody Room room) {
        Room roomSaved = roomDomain.save(room);
        if (roomSaved == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok().body(roomSaved);
    }

    @Operation(summary = "Obtener todos las habitaciones")
    @GetMapping("/")
    public List<Room> findAll() {
        return roomDomain.findAll();
    }

    @Operation(summary = "Borrar habitacion")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "habitacion borrada correctamente"),
            @ApiResponse(responseCode = "404", description = "habitacion no encontrada")
    })
    @DeleteMapping("/{id}")
    public Map<String, Boolean> deleteById(@PathVariable(value = "id") String id) {
        boolean respuesta = roomDomain.deleteById(id);
        Map<String, Boolean> response = new HashMap<>();
        response.put("borrada", respuesta);
        return response;

    }
}