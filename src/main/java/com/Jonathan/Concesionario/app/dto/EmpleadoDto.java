package com.Jonathan.Concesionario.app.dto;

import com.Jonathan.Concesionario.app.entity.Concesionario;
import lombok.Data;
import org.springframework.stereotype.Component;

@Data
@Component
public class EmpleadoDto {
    private int id;
    private String nombres;
    private String apellidos;
    private int telefono;
    private String correo;

    //private Concesionario concesionario;
}
