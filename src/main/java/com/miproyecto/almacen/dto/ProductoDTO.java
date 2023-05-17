package com.miproyecto.almacen.dto;

import lombok.Data;

@Data
public class ProductoDTO {
    private Long id;
    private String nombre;
    private String descripcion;
    private int cantidadEnStock;
    private Double precio;
    private MarcaDTO marca;
    private RubroDTO rubro;
}
