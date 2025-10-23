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
import com.huertohogarJV.backend.Models.Carrito;
import com.huertohogarJV.backend.Service.CarritoService;

@RestController
@RequestMapping("api/carrito")
public class CarritoController {
    @Autowired
    private CarritoService carritoService;

    @PostMapping
    public ResponseEntity<Carrito> crearCarrito(@RequestBody Carrito carrito){
        Carrito newCarrito = carritoService.crearCarrito(carrito);
        return ResponseEntity.status(HttpStatus.CREATED).body(newCarrito);
    }

    @GetMapping
    public List<Carrito> listarCarritos(){
        return carritoService.listarCarritos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Carrito> buscarxid(@PathVariable Long id){
        return carritoService.buscarxid(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<Carrito> actualizarCarrito(@PathVariable Long id, @RequestBody Carrito newCarrito){
        Carrito actualizado = carritoService.actualizarCarrito(id, newCarrito);
        return ResponseEntity.ok(actualizado);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCarrito(@PathVariable Long id){
        carritoService.eliminarCarrito(id);
        return ResponseEntity.noContent().build();
    }
}
