package com.miproyecto.almacen.servicio.contratos;

import com.miproyecto.almacen.dto.ProductoDTO;

import java.util.List;

public interface IProductoService {

    ProductoDTO saveProducto(ProductoDTO productoDTO);
    ProductoDTO findProductoById(Long productoId);
    List<ProductoDTO> findAllProducto();
    ProductoDTO updateProducto(Long productoId, ProductoDTO productoDTO);
    void deleteProducto(Long productoId);

}
