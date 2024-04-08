package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.MarcaDTO;
import com.miproyecto.almacen.servicio.MarcaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/marcas")
public class MarcaControlador {

    @Autowired
    private MarcaService marcaService;

    @GetMapping()
    public ResponseEntity<List<MarcaDTO>> getAllMarcas() {
        List<MarcaDTO> marcaDTOList = marcaService.findAllMarca();
        return new ResponseEntity<>(marcaDTOList, HttpStatus.OK);
    }
    @GetMapping("/{marcaId}")
    public ResponseEntity<MarcaDTO> getMarcaById(@PathVariable Long marcaId) {
        MarcaDTO marcaDTO = marcaService.findMarcaById(marcaId);
        if(marcaDTO == null)
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        return new ResponseEntity<>(marcaDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<MarcaDTO> createMarca(@RequestBody MarcaDTO marcaDTO) {
        MarcaDTO marcaDTOnueva = marcaService.saveMarca(marcaDTO);
        return new ResponseEntity<>(marcaDTOnueva, HttpStatus.CREATED);
    }

    @PutMapping("/{marcaId}")
    public ResponseEntity<MarcaDTO> updateMarca(@RequestBody MarcaDTO marcaDTO, @PathVariable Long marcaId) {
        MarcaDTO marcaDTOactualizada = marcaService.updateMarca(marcaId, marcaDTO);
        return new ResponseEntity<>(marcaDTOactualizada, HttpStatus.OK);
    }

    @DeleteMapping("/{marcaId}")
    public ResponseEntity<Void> deleteMarca(@PathVariable Long marcaId) {
        marcaService.deleteMarca(marcaId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
