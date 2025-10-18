package com.huertohogarJV.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huertohogarJV.backend.Models.Carrito;
import com.huertohogarJV.backend.Repository.CarritoRepository;

@Service
public class CarritoService {
    @Autowired
    private CarritoRepository carritoRepository;

    public Carrito crearCarrito(Carrito carrito){
        return carritoRepository.save(carrito);
    }

    public Optional<Carrito> buscarxid(Long id){
        return carritoRepository.findById(id);
    }

    public List<Carrito> listarCarritos(){
        return carritoRepository.findAll();
    }

    public void eliminarCarrito(Long id){
        carritoRepository.deleteById(id);
    }

    public Carrito actualizarCarrito(Long id, Carrito carritoActualizado) {
        Carrito carritoExistente = carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));
        carritoExistente.getItems().clear();
        if (carritoActualizado.getItems() != null) {
            carritoExistente.getItems().addAll(carritoActualizado.getItems());
        }
        return carritoRepository.save(carritoExistente);
    }
}
