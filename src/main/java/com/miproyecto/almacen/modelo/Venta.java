package com.miproyecto.almacen.modelo;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.util.List;

@Getter @Setter
public class Venta {
    private Date fechaDeVenta;
    private List<LineaDeVenta> detalleDeVenta;

    private Long CalcularTotal() {
        long sumatoria = 0L;
        for (LineaDeVenta lv :
                detalleDeVenta) {
            sumatoria += lv.CalcularSubtotal();
        }
        return sumatoria;
    }
}
