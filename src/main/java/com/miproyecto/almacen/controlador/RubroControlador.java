package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.RubroDTO;
import com.miproyecto.almacen.servicio.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rubros")
public class RubroControlador {
    @Autowired
    private RubroService rubroService;

    @GetMapping
    public ResponseEntity<List<RubroDTO>> getAllRubros() {
        List<RubroDTO> rubroDTOList = rubroService.findAllRubro();
        return  new ResponseEntity<>(rubroDTOList, HttpStatus.OK);
    }

    @GetMapping("/{rubroId}")
    public ResponseEntity<RubroDTO> getRubroById(@PathVariable Long rubroId) {
        RubroDTO rubroDTO = rubroService.findRubroById(rubroId);
        return rubroDTO == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(rubroDTO, HttpStatus.OK);
    }

    @PostMapping()
    public ResponseEntity<RubroDTO> createRubro(@RequestBody RubroDTO rubroDTO) {
        RubroDTO rubroDTOnuevo = rubroService.saveRubro(rubroDTO);
        return new ResponseEntity<>(rubroDTOnuevo, HttpStatus.CREATED);
    }

    @PutMapping("/{rubroId}")
    public ResponseEntity<RubroDTO> updateRubro(@RequestBody RubroDTO rubroDTO, @PathVariable Long rubroId) {
        RubroDTO rubroDTOactualizado = rubroService.updateRubro(rubroId, rubroDTO);
        return new ResponseEntity<>(rubroDTOactualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{rubroId}")
    public ResponseEntity<Void> deleteRubro(@PathVariable Long rubroId) {
        rubroService.deleteRubro(rubroId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
