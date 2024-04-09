package com.miproyecto.almacen.controlador;

import com.miproyecto.almacen.dto.ProductoDTO;
import com.miproyecto.almacen.servicio.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productos")
public class ProductoControlador {

    @Autowired
    private ProductoService service;

    @PostMapping()
    public ResponseEntity<ProductoDTO> createProducto(@RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoDTONuevo = service.saveProducto(productoDTO);
        return new ResponseEntity<>(productoDTONuevo, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<ProductoDTO>> getAllProductos() {
        List<ProductoDTO> productoDTOList = service.findAllProducto();
        return new ResponseEntity<>(productoDTOList, HttpStatus.OK);
    }

    @GetMapping("/{productoId}")
    public ResponseEntity<ProductoDTO> getProductoById(@PathVariable Long productoId) {
        ProductoDTO productoDTO = service.findProductoById(productoId);

        return productoDTO == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(productoDTO, HttpStatus.OK);
    }

    @PutMapping("/{productoId}")
    public ResponseEntity<ProductoDTO> updateProducto(@PathVariable Long productoId, @RequestBody ProductoDTO productoDTO) {
        ProductoDTO productoDTOActualizado = service.updateProducto(productoId, productoDTO);
        return new ResponseEntity<>(productoDTOActualizado, HttpStatus.OK);
    }

    @DeleteMapping("/{productoId}")
    public ResponseEntity<Void> deleteProducto(@PathVariable Long productoId) {
        service.deleteProducto(productoId);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
