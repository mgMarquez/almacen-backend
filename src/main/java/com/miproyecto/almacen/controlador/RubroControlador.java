package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.RubroDTO;
import com.miproyecto.almacen.servicio.RubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rubros")
public class RubroControlador {
    @Autowired
    private RubroService service;

    @GetMapping
    public List<RubroDTO> getAllRubros() {
        return service.findAllRubro();
    }

    @GetMapping("/{rubroId}")
    public RubroDTO getRubroById(@PathVariable Long rubroId) {
        return service.findRubroById(rubroId);
    }

    @PostMapping()
    public RubroDTO createRubro(@RequestBody RubroDTO rubroDTO) {
        return service.saveRubro(rubroDTO);
    }

    @PutMapping("/{rubroId}")
    public RubroDTO updateRubro(@RequestBody RubroDTO rubroDTO, @PathVariable Long rubroId) {
        return service.updateRubro(rubroId, rubroDTO);
    }

    @DeleteMapping("/{rubroId}")
    public void deleteRubro(@PathVariable Long rubroId) {
        service.deleteRubro(rubroId);
    }
}
