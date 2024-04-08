package com.miproyecto.almacen.repositorio;

import com.miproyecto.almacen.modelo.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MarcaRepository extends JpaRepository<Marca, Long> {
}
