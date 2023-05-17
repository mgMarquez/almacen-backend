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
    private int cantidadEnStock;
    private Long precio;
    @ManyToOne(optional = false)
    @JoinColumn(name = "marca_id")
    private Marca marca;
    @ManyToOne(optional = false)
    @JoinColumn(name = "rubro_id")
    private Rubro rubro;

}
