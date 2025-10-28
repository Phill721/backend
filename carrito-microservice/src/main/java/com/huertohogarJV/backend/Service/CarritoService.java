package com.huertohogarJV.backend.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.huertohogarJV.backend.DTOs.CarritoDTO;
import com.huertohogarJV.backend.DTOs.ItemCarritoDTO;
import com.huertohogarJV.backend.Entity.Carrito;
import com.huertohogarJV.backend.Entity.ItemCarrito;
import com.huertohogarJV.backend.Repository.CarritoRepository;

@Service
public class CarritoService {

    @Autowired
    private CarritoRepository carritoRepository;

    public CarritoDTO crearCarrito(CarritoDTO carritoDTO) {
        Carrito carrito = convertirAEntidad(carritoDTO);
        Carrito guardado = carritoRepository.save(carrito);
        return convertirADTO(guardado);
    }

    public Optional<CarritoDTO> buscarxid(Long id) {
        return carritoRepository.findById(id)
                .map(this::convertirADTO);
    }

    public List<CarritoDTO> listarCarritos() {
        return carritoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }
    public void eliminarCarrito(Long id) {
        carritoRepository.deleteById(id);
    }

    public CarritoDTO actualizarCarrito(Long id, CarritoDTO carritoActualizadoDTO) {
        Carrito carritoExistente = carritoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Carrito no encontrado"));

        carritoExistente.getItems().clear();

        if (carritoActualizadoDTO.getItems() != null) {
            carritoExistente.getItems().addAll(
                carritoActualizadoDTO.getItems().stream()
                    .map(this::convertirItemAEntidad)
                    .collect(Collectors.toList())
            );
        }

        carritoExistente.setUsuario_id(carritoActualizadoDTO.getUsuario_id());
        carritoExistente.setTotal(carritoActualizadoDTO.getTotal());

        Carrito actualizado = carritoRepository.save(carritoExistente);
        return convertirADTO(actualizado);
    }
    // Métodos de conversión
    private CarritoDTO convertirADTO(Carrito carrito) {
        CarritoDTO dto = new CarritoDTO();
        dto.setId(carrito.getId());
        dto.setUsuario_id(carrito.getUsuario_id());
        dto.setTotal(carrito.getTotal());

        if (carrito.getItems() != null) {
            dto.setItems(
                carrito.getItems().stream()
                    .map(this::convertirItemADTO)
                    .collect(Collectors.toList())
            );
        }

        return dto;
    }

    private Carrito convertirAEntidad(CarritoDTO dto) {
        Carrito carrito = new Carrito();
        carrito.setId(dto.getId());
        carrito.setUsuario_id(dto.getUsuario_id());
        carrito.setTotal(dto.getTotal());

        if (dto.getItems() != null) {
            carrito.setItems(
                dto.getItems().stream()
                    .map(this::convertirItemAEntidad)
                    .collect(Collectors.toList())
            );
        }

        return carrito;
    }

    private ItemCarritoDTO convertirItemADTO(ItemCarrito item) {
        ItemCarritoDTO dto = new ItemCarritoDTO();
        dto.setProductoId(item.getProductoId());
        dto.setCantidad(item.getCantidad());
        dto.setPrecioUnitario(item.getPrecioUnitario());
        return dto;
    }

    private ItemCarrito convertirItemAEntidad(ItemCarritoDTO dto) {
        ItemCarrito item = new ItemCarrito();
        item.setProductoId(dto.getProductoId());
        item.setCantidad(dto.getCantidad());
        item.setPrecioUnitario(dto.getPrecioUnitario());
        return item;
    }
}