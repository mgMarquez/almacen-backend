package com.miproyecto.almacen.servicio.impl;

import com.miproyecto.almacen.dto.MarcaDTO;
import com.miproyecto.almacen.modelo.Marca;
import com.miproyecto.almacen.repositorio.MarcaRepository;
import com.miproyecto.almacen.servicio.MarcaService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class MarcaServiceImpl implements MarcaService {
    @Autowired
    private MarcaRepository marcaRepository;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public MarcaDTO saveMarca(MarcaDTO marcaDTO) {
        Marca marca = mapearEntidad(marcaDTO);
        Marca nuevaMarca = marcaRepository.save(marca);
        return mapearDTO(nuevaMarca);
    }

    @Override
    public MarcaDTO findMarcaById(Long marcaId) {
        Marca marca = marcaRepository.findById(marcaId).orElse(null);
        return marca != null? mapearDTO(marca) : null;
    }

    @Override
    public List<MarcaDTO> findAllMarca() {
        List<Marca> marcas = marcaRepository.findAll();
        return marcas
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public MarcaDTO updateMarca(Long marcaId, MarcaDTO marcaDTO) {
        marcaDTO.setId(marcaId);
        Marca marca = mapearEntidad(marcaDTO);
        Marca marcaActualizada = marcaRepository.save(marca);
        return mapearDTO(marcaActualizada);
    }

    @Override
    public void deleteMarca(Long marcaId) {
        marcaRepository.deleteById(marcaId);
    }

    private MarcaDTO mapearDTO(Marca marca) {
        return modelMapper.map(marca, MarcaDTO.class);
    }

    private Marca mapearEntidad(MarcaDTO marcaDTO) {
        return modelMapper.map(marcaDTO, Marca.class);
    }
}
