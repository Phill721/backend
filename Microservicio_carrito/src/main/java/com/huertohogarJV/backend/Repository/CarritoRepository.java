package com.huertohogarJV.backend.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.huertohogarJV.backend.Models.Carrito;

@Repository
public interface CarritoRepository extends JpaRepository<Carrito, Long> {
    
}
