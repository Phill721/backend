package com.huertohogarJV.backend.Models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoDTO {
    private String id;
    private String nombre;
    private String descripcion;
    private Integer precio;
}
