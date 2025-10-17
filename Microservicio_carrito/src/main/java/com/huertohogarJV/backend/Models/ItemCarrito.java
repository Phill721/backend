package com.huertohogarJV.backend.Models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class ItemCarrito {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String productoId; // referencia al id del producto que esta en otro microservicio
    private Integer cantidad;
    private String nombreProducto; // referencia al nombre de producto que esta en otro microservicio
    private String descripcionProducto; // referencia a la descripcion del producto que esta en otro microservicio
    private Integer precioUnitario; // referencia al precio unitario de producto que esta en otro microservicio

    public Integer getSubtotal(){
        if (precioUnitario == null || cantidad == null) return 0;
        return precioUnitario * cantidad;
    }
}
