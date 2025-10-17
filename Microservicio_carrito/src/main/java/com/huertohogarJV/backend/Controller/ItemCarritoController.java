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

import com.huertohogarJV.backend.Models.ItemCarrito;
import com.huertohogarJV.backend.Service.ItemCarritoService;

@RestController
@RequestMapping("api/item")
public class ItemCarritoController {
    @Autowired
    private ItemCarritoService itemCarritoService;

    @PostMapping
    public ResponseEntity<ItemCarrito> crearItem(@RequestBody ItemCarrito item){
        ItemCarrito newItem = itemCarritoService.crearItem(item);
        return ResponseEntity.status(HttpStatus.CREATED).body(newItem);
    }

    @GetMapping
    public List<ItemCarrito> listarItems(){
        return itemCarritoService.listarItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemCarrito> buscarxid(@PathVariable Long id){
        return itemCarritoService.buscarxid(id)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemCarrito> actualizarItem(@PathVariable Long id, @RequestBody ItemCarrito newItem){
        return itemCarritoService.actualizarItem(id, newItem)
            .map(ResponseEntity::ok)
            .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarItem(@PathVariable Long id){
        itemCarritoService.eliminarItem(id);
        return ResponseEntity.noContent().build();
    }
}
