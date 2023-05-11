package com.miproyecto.almacen.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@Entity
public class Producto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String nombre;
    private String descripcion;
    @ManyToOne
    @JoinColumn(name = "marca_id")
    private Marca marca;
    @ManyToOne
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;
    private int cantidadEnStock;
    private Long precio;
}
