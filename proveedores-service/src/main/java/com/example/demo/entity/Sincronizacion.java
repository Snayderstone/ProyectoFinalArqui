package com.example.demo.entity;
import lombok.AllArgsConstructor;
import org.springframework.data.annotation.Id;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "Sincronizacion")
@Data
@AllArgsConstructor
public class Sincronizacion {
    @Id
     private int id;

     private Date Fecha;

     private String estado;

     private Producto producto;

}


