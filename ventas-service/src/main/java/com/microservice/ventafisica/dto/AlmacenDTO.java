package com.microservice.ventafisica.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class AlmacenDTO {
    private String nombre;
    private String ubicacion;
}
