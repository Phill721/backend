package com.huertohogarJV.backend.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.huertohogarJV.backend.DTOs.ItemCarritoDTO;
import com.huertohogarJV.backend.Service.ItemCarritoService;

@RestController
@RequestMapping("api/item")
public class ItemCarritoController {

    @Autowired
    private ItemCarritoService itemCarritoService;

    @PostMapping
    public ResponseEntity<ItemCarritoDTO> crearItem(@RequestBody ItemCarritoDTO itemDTO) {
        ItemCarritoDTO nuevoItem = itemCarritoService.crearItem(itemDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(nuevoItem);
    }

    @GetMapping
    public ResponseEntity<List<ItemCarritoDTO>> listarItems() {
        List<ItemCarritoDTO> items = itemCarritoService.listarItems();
        return ResponseEntity.ok(items);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCarritoDTO> buscarxid(@PathVariable Long id) {
        return itemCarritoService.buscarxid(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCarritoDTO> actualizarItem(@PathVariable Long id, @RequestBody ItemCarritoDTO itemDTO) {
        return itemCarritoService.actualizarItem(id, itemDTO)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id) {
        itemCarritoService.eliminarItem(id);
        return ResponseEntity.noContent().build();
    }
}
