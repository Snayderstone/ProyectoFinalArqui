package com.example.demo.Service;

import com.example.demo.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ProductoService {

    public List<Producto> listAllProduct();

    public Producto getProducto(Integer id);

    public Producto createProducto(Producto producto);

    public Producto updateProducto(Producto producto);

    public Producto deleteProducto(Integer id);


}
