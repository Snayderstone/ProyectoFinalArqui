package com.example.demo.Service.impl;
import com.example.demo.entity.Producto;
import com.example.demo.repository.ProductoRepository;
import com.example.demo.Service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;
    @Override
    public List<Producto> listAllProduct() {

        return productoRepository.findAll();
    }

    @Override
    public Producto getProducto(Integer id) {

        return productoRepository.findById(id).orElse(null);
    }

    @Override
    public Producto createProducto(Producto producto) {
        producto.setStatus("CREATED");
        return productoRepository.save(producto);
    }

    @Override
    public Producto updateProducto(Producto producto) {
        Producto productoDB = getProducto(producto.getId());
        if (null == productoDB){
            return null;
        }

        productoDB.setNombre(producto.getNombre());
        productoDB.setDescripcion(producto.getDescripcion());
        productoDB.setPrecio(producto.getPrecio());
        productoDB.setStock(producto.getStock());
        return productoRepository.save(productoDB);
    }

    @Override
    public Producto deleteProducto(Integer id) {
        Producto productoDB = getProducto(id);
        if (null == productoDB){
            return null;
        }
        productoDB.setStatus("DELETED");
        return productoRepository.save(productoDB);
    }
}
