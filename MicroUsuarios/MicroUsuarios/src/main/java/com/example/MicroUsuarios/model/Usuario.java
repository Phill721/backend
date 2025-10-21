package com.example.MicroUsuarios.model;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Enumerated;
import jakarta.persistence.EnumType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuarios")

public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nombre;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Roles rol;

    // Métodos para verificar roles y permisos

    public boolean tienePermiso(Permisos permiso) {
        return this.rol.tienePermiso(permiso);
    }
    
    public boolean tieneRol(Roles rol) {
        return this.rol == rol;
    }
    
    public List<Permisos> getPermisos() {
        return this.rol.getPermisos();
    }
}

