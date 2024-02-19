package com.example.demo.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Proveedor")
@Data
@AllArgsConstructor
public class Proveedor {
    //Para definir llave principal y autoincremental
    @Id
    private int id;

    private String nombre;

    private String apellido;

    private String ruc;

    private String telf;

    private String correo;

    private String direccion;

    private String status;

}
