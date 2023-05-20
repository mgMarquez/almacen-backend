package com.miproyecto.almacen.servicio;

import com.miproyecto.almacen.dto.ProductoDTO;
import com.miproyecto.almacen.modelo.Marca;
import com.miproyecto.almacen.modelo.Producto;
import com.miproyecto.almacen.modelo.Rubro;
import com.miproyecto.almacen.repositorio.IMarcaRepository;
import com.miproyecto.almacen.repositorio.IProductoRepository;
import com.miproyecto.almacen.repositorio.IRubroRepository;
import com.miproyecto.almacen.servicio.contratos.IProductoService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ImpProductoService implements IProductoService {

    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private IProductoRepository repo;
    @Autowired
    private IMarcaRepository repoMarca;
    @Autowired
    private IRubroRepository repoRubro;

    @Override
    public ProductoDTO saveProducto(ProductoDTO productoDTO) {
        Marca marca = repoMarca.findById(productoDTO.getMarca().getId()).orElse(null);
        Rubro rubro = repoRubro.findById(productoDTO.getRubro().getId()).orElse(null);
        Producto producto = mapearEntidad(productoDTO);
        producto.setMarca(marca);
        producto.setRubro(rubro);
        Producto productoNuevo = repo.save(producto);
        return mapearDTO(productoNuevo);
    }

    @Override
    public ProductoDTO findProductoById(Long productoId) {
        Producto producto = repo.findById(productoId).orElse(null);
        return mapearDTO(producto);
    }

    @Override
    public List<ProductoDTO> findAllProducto() {
        List<Producto> productos = repo.findAll();
        return productos
                .stream()
                .map(this::mapearDTO)
                .collect(Collectors.toList());
    }

    @Override
    public ProductoDTO updateProducto(Long productoId, ProductoDTO productoDTO) {
        Producto producto = mapearEntidad(productoDTO);
        Producto productoNuevo = repo.save(producto);
        return mapearDTO(productoNuevo);
    }

    @Override
    public void deleteProducto(Long productoId) {
        repo.deleteById(productoId);
    }

    private ProductoDTO mapearDTO(Producto producto) {
        return modelMapper.map(producto, ProductoDTO.class);
    }

    private Producto mapearEntidad(ProductoDTO productoDTO) {
        return modelMapper.map(productoDTO, Producto.class);
    }
}
