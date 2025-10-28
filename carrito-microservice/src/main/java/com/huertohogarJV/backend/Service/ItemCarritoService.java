package com.huertohogarJV.backend.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huertohogarJV.backend.DTOs.ItemCarritoDTO;
import com.huertohogarJV.backend.Entity.ItemCarrito;
import com.huertohogarJV.backend.Repository.ItemCarritoRepository;

@Service
public class ItemCarritoService {

    @Autowired
    private ItemCarritoRepository itemCarritoRepository;
    public ItemCarritoDTO crearItem(ItemCarritoDTO itemDTO) {
        ItemCarrito item = convertirAEntidad(itemDTO);
        ItemCarrito guardado = itemCarritoRepository.save(item);
        return convertirADTO(guardado);
    }

    public Optional<ItemCarritoDTO> buscarxid(Long id) {
        return itemCarritoRepository.findById(id)
                .map(this::convertirADTO);
    }

    public List<ItemCarritoDTO> listarItems() {
        return itemCarritoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    public Optional<ItemCarritoDTO> actualizarItem(Long id, ItemCarritoDTO itemDTO) {
        return itemCarritoRepository.findById(id).map(itemExistente -> {
            itemExistente.setCantidad(itemDTO.getCantidad());
            itemExistente.setPrecioUnitario(itemDTO.getPrecioUnitario());
            itemExistente.setProductoId(itemDTO.getProductoId());
            itemExistente.setNombreProducto(itemDTO.getNombreProducto());
            itemExistente.setDescripcionProducto(itemDTO.getDescripcionProducto());

            ItemCarrito actualizado = itemCarritoRepository.save(itemExistente);
            return convertirADTO(actualizado);
        });
    }

    public void eliminarItem(Long id) {
        itemCarritoRepository.deleteById(id);
    }

    // Métodos de conversión
    private ItemCarritoDTO convertirADTO(ItemCarrito item) {
        ItemCarritoDTO dto = new ItemCarritoDTO();
        dto.setId(item.getId());
        dto.setProductoId(item.getProductoId());
        dto.setCantidad(item.getCantidad());
        dto.setPrecioUnitario(item.getPrecioUnitario());
        dto.setNombreProducto(item.getNombreProducto());
        dto.setDescripcionProducto(item.getDescripcionProducto());
        return dto;
    }

    private ItemCarrito convertirAEntidad(ItemCarritoDTO dto) {
        ItemCarrito item = new ItemCarrito();
        item.setId(dto.getId());
        item.setProductoId(dto.getProductoId());
        item.setCantidad(dto.getCantidad());
        item.setPrecioUnitario(dto.getPrecioUnitario());
        item.setNombreProducto(dto.getNombreProducto());
        item.setDescripcionProducto(dto.getDescripcionProducto());
        return item;
    }
}
