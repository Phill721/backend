package com.mnegocio.core_microservicio.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mnegocio.core_microservicio.DTOs.ProductoDTO;
import com.mnegocio.core_microservicio.Entity.ProductoEntity;
import com.mnegocio.core_microservicio.Repository.ProductoRepository;

@Service
public class ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    // Crear producto
    public ProductoDTO crearProducto(ProductoDTO productoDTO) {
        ProductoEntity producto = convertirAEntidad(productoDTO);
        ProductoEntity guardado = productoRepository.save(producto);
        return convertirADTO(guardado);
    }

    // Buscar producto por ID
    public Optional<ProductoDTO> buscarPorId(Long id) {
        return productoRepository.findById(id)
                .map(this::convertirADTO);
    }

    // Listar todos los productos
    public List<ProductoDTO> listarProductos() {
        return productoRepository.findAll()
                .stream()
                .map(this::convertirADTO)
                .collect(Collectors.toList());
    }

    // Eliminar producto
    public void eliminarProducto(Long id) {
        productoRepository.deleteById(id);
    }

    // Actualizar producto
    public ProductoDTO actualizarProducto(Long id, ProductoDTO productoActualizadoDTO) {
        ProductoEntity productoExistente = productoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Producto no encontrado con ID: " + id));

        productoExistente.setNombre(productoActualizadoDTO.getNombre());
        productoExistente.setDescripcion(productoActualizadoDTO.getDescripcion());
        productoExistente.setPrecio(productoActualizadoDTO.getPrecio());
        productoExistente.setImagen1(productoActualizadoDTO.getImagen1());
        productoExistente.setImagen2(productoActualizadoDTO.getImagen2());
        productoExistente.setImagen3(productoActualizadoDTO.getImagen3());
        productoExistente.setImagen4(productoActualizadoDTO.getImagen4());
        productoExistente.setCategoria(productoActualizadoDTO.getCategoria());

        ProductoEntity actualizado = productoRepository.save(productoExistente);
        return convertirADTO(actualizado);
    }

    // Conversión de Entity a DTO
    private ProductoDTO convertirADTO(ProductoEntity producto) {
        ProductoDTO dto = new ProductoDTO();
        dto.setId(producto.getId());
        dto.setNombre(producto.getNombre());
        dto.setDescripcion(producto.getDescripcion());
        dto.setPrecio(producto.getPrecio());
        dto.setImagen1(producto.getImagen1());
        dto.setImagen2(producto.getImagen2());
        dto.setImagen3(producto.getImagen3());
        dto.setImagen4(producto.getImagen4());
        dto.setCategoria(producto.getCategoria());
        return dto;
    }

    // Conversión de DTO a Entity
    private ProductoEntity convertirAEntidad(ProductoDTO dto) {
        ProductoEntity producto = new ProductoEntity();
        producto.setId(dto.getId());
        producto.setNombre(dto.getNombre());
        producto.setDescripcion(dto.getDescripcion());
        producto.setPrecio(dto.getPrecio());
        producto.setImagen1(dto.getImagen1());
        producto.setImagen2(dto.getImagen2());
        producto.setImagen3(dto.getImagen3());
        producto.setImagen4(dto.getImagen4());
        producto.setCategoria(dto.getCategoria());
        return producto;
    }
}
