package com.miproyecto.almacen.servicio;

import com.miproyecto.almacen.dto.MarcaDTO;

import java.util.List;

public interface MarcaService {
    MarcaDTO saveMarca(MarcaDTO marcaDTO);
    MarcaDTO findMarcaById(Long marcaId);
    List<MarcaDTO> findAllMarca();
    MarcaDTO updateMarca(Long marcaId, MarcaDTO marcaDTO);
    void deleteMarca(Long marcaId);
}
