package com.miproyecto.almacen.repositorio;

import com.miproyecto.almacen.modelo.Rubro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RubroRepository extends JpaRepository<Rubro, Long> {
}
