package com.huertohogarJV.backend.DTOs;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CarritoDTO {
    private Long id;
    private String usuario_id;
    private List<ItemCarritoDTO> items;
    private Integer total;
}
