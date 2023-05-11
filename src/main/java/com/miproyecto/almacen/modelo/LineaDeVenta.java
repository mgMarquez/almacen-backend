package com.miproyecto.almacen.modelo;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class LineaDeVenta {
    private Producto producto;
    private int cantidad;
    public Long CalcularSubtotal() {
        return producto.getPrecio() * cantidad;
    }
}
