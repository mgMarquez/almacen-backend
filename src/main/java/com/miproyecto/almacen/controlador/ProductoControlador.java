package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.ProductoDTO;
import com.miproyecto.almacen.servicio.ImpProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/producto")
public class ProductoControlador {

    @Autowired
    private ImpProductoService service;

    @PostMapping("/create")
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO) {
        return service.saveProducto(productoDTO);
    }
    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        return service.findAllProducto();
    }


}
