package com.miproyecto.almacen.servicio.impl;

import com.miproyecto.almacen.dto.RubroDTO;
import com.miproyecto.almacen.modelo.Rubro;
import com.miproyecto.almacen.repositorio.RubroRepository;
import com.miproyecto.almacen.servicio.RubroService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RubroServiceImpl implements RubroService {
    @Autowired
    private RubroRepository repo;
    @Autowired
    private ModelMapper modelMapper;
    
    @Override
    public RubroDTO saveRubro(RubroDTO rubroDTO) {
        Rubro rubro = mapearEntidad(rubroDTO);
        Rubro nuevoRubro = repo.save(rubro);
        return mapearDTO(nuevoRubro);
    }

    @Override
    public RubroDTO findRubroById(Long rubroId) {
        Rubro rubro = repo.findById(rubroId).orElse(null);
        return mapearDTO(rubro);
    }

    @Override
    public List<RubroDTO> findAllRubro() {
        List<Rubro> rubros = repo.findAll();
        return rubros
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public RubroDTO updateRubro(Long rubroId, RubroDTO rubroDTO) {
        rubroDTO.setId(rubroId);
        Rubro rubro = mapearEntidad(rubroDTO);
        Rubro rubroActualizado = repo.save(rubro);
        return mapearDTO(rubroActualizado);
    }

    @Override
    public void deleteRubro(Long rubroId) {
        repo.deleteById(rubroId);
    }

    private RubroDTO mapearDTO(Rubro rubro) {
        return modelMapper.map(rubro, RubroDTO.class);
    }

    private Rubro mapearEntidad(RubroDTO rubroDTO) {
        return modelMapper.map(rubroDTO, Rubro.class);
    }
}
