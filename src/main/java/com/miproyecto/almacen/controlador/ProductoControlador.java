package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.ProductoDTO;
import com.miproyecto.almacen.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {

    @Autowired
    private ProductoService service;

    @PostMapping()
    public ProductoDTO createProducto(@RequestBody ProductoDTO productoDTO) {
        return service.saveProducto(productoDTO);
    }
    @GetMapping
    public List<ProductoDTO> getAllProductos() {
        return service.findAllProducto();
    }

    @GetMapping("/{productoId}")
    public ProductoDTO getProductoById(@PathVariable Long productoId) {
        return service.findProductoById(productoId);
    }

    @PutMapping("/{productoId}")
    public ProductoDTO updateProducto(@PathVariable Long productoId, @RequestBody ProductoDTO productoDTO) {
        return service.updateProducto(productoId, productoDTO);
    }

    @DeleteMapping("/{productoId}")
    public void deleteProducto(@PathVariable Long productoId) {
        service.deleteProducto(productoId);
    }
}
