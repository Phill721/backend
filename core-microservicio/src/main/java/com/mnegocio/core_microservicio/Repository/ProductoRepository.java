package com.mnegocio.core_microservicio.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mnegocio.core_microservicio.Entity.ProductoEntity;

public interface ProductoRepository extends JpaRepository<ProductoEntity, Long>{
    
}
