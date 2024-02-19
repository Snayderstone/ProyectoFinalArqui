package com.example.demo.entity;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Producto")
@Data
@AllArgsConstructor
public class Producto {

    @Id
    private int id;

    private String nombre;

    private String descripcion;

    private double stock;

    private double precio;

    private Proveedor proveedor;

    private String status;
}
