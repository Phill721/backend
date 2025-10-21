package com.example.MicroUsuarios.model;

import java.util.Arrays;
import java.util.List;

public enum Roles {
    ADMIN(Arrays.asList(Permisos.LEER, Permisos.GESTION_VENTAS, Permisos.ADMINISTRACION)),
    VENDEDOR(Arrays.asList(Permisos.LEER, Permisos.GESTION_VENTAS)),
    USER(Arrays.asList(Permisos.LEER));

    private final List<Permisos> permisos;

    Roles(List<Permisos> permisos) {
        this.permisos = permisos;
    }

    public List<Permisos> getPermisos() {
        return permisos;
    }

    public boolean tienePermiso(Permisos permiso) {
        return this.permisos.contains(permiso);
    }
}

