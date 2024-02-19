package com.example.demo.entity;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.Date;
import java.util.List;
@Document(collection = "OrdenCompra")
@Data
@AllArgsConstructor
public class OrdenCompra {

    @Id
    private int id;

    private Date fechaOrden;

    private String estadoOrden;

    private double totalOrden;

    private Proveedor proveedor;

    private List<DetalleCompra> detallesCompra;

    private String status;

}



