package com.example.MicroUsuarios.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.MicroUsuarios.model.Roles;
import com.example.MicroUsuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    List<Usuario> findByRol(Roles rol);
}
