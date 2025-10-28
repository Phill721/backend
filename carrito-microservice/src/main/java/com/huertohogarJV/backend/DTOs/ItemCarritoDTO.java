package com.huertohogarJV.backend.DTOs;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ItemCarritoDTO {
    private Long id;
    private String productoId;
    private Integer cantidad;
    private String nombreProducto; 
    private String descripcionProducto; 
    private Integer precioUnitario;
}
