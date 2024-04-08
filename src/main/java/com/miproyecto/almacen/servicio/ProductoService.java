package com.miproyecto.almacen.servicio;

import com.miproyecto.almacen.dto.ProductoDTO;

import java.util.List;

public interface ProductoService {

    ProductoDTO saveProducto(ProductoDTO productoDTO);
    ProductoDTO findProductoById(Long productoId);
    List<ProductoDTO> findAllProducto();
    ProductoDTO updateProducto(Long productoId, ProductoDTO productoDTO);
    void deleteProducto(Long productoId);

}
