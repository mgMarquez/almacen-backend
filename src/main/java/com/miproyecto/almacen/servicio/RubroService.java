package com.miproyecto.almacen.servicio;

import com.miproyecto.almacen.dto.RubroDTO;

import java.util.List;

public interface RubroService {
    RubroDTO saveRubro(RubroDTO rubroDTO);
    RubroDTO findRubroById(Long rubroId);
    List<RubroDTO> findAllRubro();
    RubroDTO updateRubro(Long rubroId, RubroDTO rubroDTO);
    void deleteRubro(Long rubroId);
}
