package com.miproyecto.almacen.servicio.contratos;

import com.miproyecto.almacen.dto.RubroDTO;

import java.util.List;

public interface IRubroService {
    RubroDTO saveRubro(RubroDTO rubroDTO);
    RubroDTO findRubroById(Long rubroId);
    List<RubroDTO> findAllRubro();
    RubroDTO updateRubro(Long rubroId, RubroDTO rubroDTO);
    void deleteRubro(Long rubroId);
}
