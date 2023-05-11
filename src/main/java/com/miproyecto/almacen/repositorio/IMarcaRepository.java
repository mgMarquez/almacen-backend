package com.miproyecto.almacen.repositorio;

import com.miproyecto.almacen.modelo.Marca;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IMarcaRepository extends JpaRepository<Marca, Long> {
}
