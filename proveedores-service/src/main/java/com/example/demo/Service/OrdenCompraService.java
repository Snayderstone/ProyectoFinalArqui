package com.example.demo.Service;

import com.example.demo.entity.OrdenCompra;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface OrdenCompraService {


    public List<OrdenCompra> listAllOrden();

    public OrdenCompra getOrden(Integer id);

    public OrdenCompra createOrden(OrdenCompra ordenCompra);

    public OrdenCompra updateOrden(OrdenCompra ordenCompra);

    public OrdenCompra deleteOrden(Integer id);
    double calcularTotalFactura(Integer orderId);
}
