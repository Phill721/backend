package com.huertohogarJV.backend.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huertohogarJV.backend.Models.ItemCarrito;
import com.huertohogarJV.backend.Repository.ItemCarritoRepository;

@Service
public class ItemCarritoService {
    @Autowired
    private ItemCarritoRepository itemCarritoRepository;

    public ItemCarrito crearItem(ItemCarrito item){
        return itemCarritoRepository.save(item);
    }

    public Optional<ItemCarrito> buscarxid(Long id){
        return itemCarritoRepository.findById(id);
    }

    public List<ItemCarrito> listarItems(){
        return itemCarritoRepository.findAll();
    }

    public Optional<ItemCarrito> actualizarItem(Long id, ItemCarrito itemActualizado){
        return itemCarritoRepository.findById(id).map(itemExistente -> {
            itemExistente.setCantidad(itemActualizado.getCantidad());
            itemExistente.setPrecioUnitario(itemActualizado.getPrecioUnitario());
            itemExistente.setProductoId(itemActualizado.getProductoId());
            itemExistente.setNombreProducto(itemActualizado.getNombreProducto());
            itemExistente.setDescripcionProducto(itemActualizado.getDescripcionProducto());
            return itemCarritoRepository.save(itemExistente);
        });
    }

    public void eliminarItem(Long id){
        itemCarritoRepository.deleteById(id);
    }
}
