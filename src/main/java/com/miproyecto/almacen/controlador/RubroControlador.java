package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.RubroDTO;
import com.miproyecto.almacen.servicio.ImpRubroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/rubro")
public class RubroControlador {
    @Autowired
    private ImpRubroService service;

    @GetMapping
    public List<RubroDTO> findAllRubros() {
        return service.findAllRubro();
    }
    @GetMapping("/{rubroId}")
    public RubroDTO findRubroById(@PathVariable Long rubroId) {
        return service.findRubroById(rubroId);
    }
    @PostMapping("/create")
    public RubroDTO createRubro(@RequestBody RubroDTO rubroDTO) {
        return service.saveRubro(rubroDTO);
    }
}
