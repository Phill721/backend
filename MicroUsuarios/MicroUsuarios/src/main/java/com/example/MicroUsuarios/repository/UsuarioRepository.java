package com.example.MicroUsuarios.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.MicroUsuarios.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
}
