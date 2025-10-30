package com.mnegocio.core_microservicio.DTOs;

import com.mnegocio.core_microservicio.Entity.CategoriaEnum;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private Integer precio;
    private String imagen1;
    private String imagen2;
    private String imagen3;
    private String imagen4;
    private CategoriaEnum categoria;
}
