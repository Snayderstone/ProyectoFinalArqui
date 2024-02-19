package com.example.demo.entity;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "DetalleCompra")
@Data
@AllArgsConstructor
public class DetalleCompra {
    @Id
    private int id;

    private int cantidadComprada;

    private double precioUnitario;

    private String correoCliente;

    private Producto producto;

    private String status;
}
