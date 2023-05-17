package com.miproyecto.almacen.repositorio;

import com.miproyecto.almacen.modelo.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProductoRepository extends JpaRepository<Producto, Long> {
}
