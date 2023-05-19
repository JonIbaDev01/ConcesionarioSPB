package com.Jonathan.Concesionario.app.dto;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class ConcesionarioDto {
    private int id;

    private String nombre;

    private String direccion;

    private int telefono;
}
