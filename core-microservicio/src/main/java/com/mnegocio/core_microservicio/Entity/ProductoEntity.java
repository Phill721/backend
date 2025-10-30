package com.mnegocio.core_microservicio.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductoEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String descripcion;
    @Column(nullable = false)
    private Integer precio;
    @Column(nullable = false)
    private String imagen1;
    @Column(nullable = false)
    private String imagen2;
    @Column(nullable = false)
    private String imagen3;
    @Column(nullable = false)
    private String imagen4;

    @Column(nullable = false)
    @Enumerated(EnumType.STRING)
    private CategoriaEnum categoria;
        
}
