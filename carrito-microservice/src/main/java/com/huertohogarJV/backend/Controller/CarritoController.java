package com.huertohogarJV.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.huertohogarJV.backend.DTOs.CarritoDTO;
import com.huertohogarJV.backend.Service.CarritoService;

@RestController
@RequestMapping("api/carrito")
public class CarritoController {

    @Autowired
    private CarritoService carritoService;

    // Crear carrito
    @PostMapping
    public ResponseEntity<CarritoDTO> crearCarrito(@RequestBody CarritoDTO carritoDTO) {
        CarritoDTO nuevoCarrito = carritoService.crearCarrito(carritoDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoCarrito);
    }

    // Listar carritos
    @GetMapping
    public ResponseEntity<List<CarritoDTO>> listarCarritos() {
        List<CarritoDTO> carritos = carritoService.listarCarritos();
        return ResponseEntity.ok(carritos);
    }

    // Buscar por id
    @GetMapping("/{id}")
    public ResponseEntity<CarritoDTO> buscarxid(@PathVariable Long id) {
        return carritoService.buscarxid(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Actualizar carrito
    @PutMapping("/{id}")
    public ResponseEntity<CarritoDTO> actualizarCarrito(@PathVariable Long id, @RequestBody CarritoDTO carritoDTO) {
        CarritoDTO actualizado = carritoService.actualizarCarrito(id, carritoDTO);
        return ResponseEntity.ok(actualizado);
    }

    // Eliminar carrito
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id) {
        carritoService.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }
}
