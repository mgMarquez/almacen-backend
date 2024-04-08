package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.MarcaDTO;
import com.miproyecto.almacen.servicio.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/marcas")
public class MarcaControlador {

    @Autowired
    private MarcaService service;

    @GetMapping()
    public List<MarcaDTO> getAllMarcas() {
        return service.findAllMarca();
    }
    @GetMapping("/{marcaId}")
    public MarcaDTO getMarcaById(@PathVariable Long marcaId) {
        return service.findMarcaById(marcaId);
    }

    @PostMapping()
    public MarcaDTO createMarca(@RequestBody MarcaDTO marcaDTO) {
        return service.saveMarca(marcaDTO);
    }

    @PutMapping("/{marcaId}")
    public MarcaDTO updateMarca(@RequestBody MarcaDTO marcaDTO, @PathVariable Long marcaId) {
        return service.updateMarca(marcaId, marcaDTO);
    }

    @DeleteMapping("/{marcaId}")
    public void deleteMarca(@PathVariable Long marcaId) {
        service.deleteMarca(marcaId);
    }
}
