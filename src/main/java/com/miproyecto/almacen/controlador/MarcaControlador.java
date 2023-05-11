package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.MarcaDTO;
import com.miproyecto.almacen.servicio.ImpMarcaService;
import lombok.Getter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/Marca")
public class MarcaControlador {

    @Autowired
    private ImpMarcaService service;

    @GetMapping
    public List<MarcaDTO> getAllMarcas() {
        return service.findAllMarca();
    }
    @GetMapping("/{marcaId}")
    public MarcaDTO getMarcaById(@PathVariable Long marcaId) {
        return service.findMarcaById(marcaId);
    }

    @PostMapping("/create")
    public MarcaDTO createMarca(@RequestBody MarcaDTO marcaDTO) {
        return service.saveMarca(marcaDTO);
    }
}
