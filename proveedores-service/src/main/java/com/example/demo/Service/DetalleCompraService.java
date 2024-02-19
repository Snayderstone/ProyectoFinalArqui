package com.example.demo.Service;

import com.example.demo.entity.DetalleCompra;
import com.example.demo.entity.Producto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface DetalleCompraService {

    public List<DetalleCompra> listAllDetalle();

    public DetalleCompra getDetalle(Integer id);

    public DetalleCompra createDetalle(DetalleCompra detalleCompra);

    public DetalleCompra updateDetalle(DetalleCompra detalleCompra);

    public DetalleCompra deleteDetalle(Integer id);

    List<Producto> FindByIdProducto(Integer id);

}
