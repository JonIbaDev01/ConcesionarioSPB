package com.Jonathan.Concesionario.app.dto;

import com.Jonathan.Concesionario.app.entity.Concesionario;
import com.Jonathan.Concesionario.app.entity.Vehiculo;
import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
@Data
@Component
public class VehiculoDto {
    private int id;
    private String tipoVehiculo;
    private int modelo;
    private int centCubicos;
    private String placa;
    private int precio;
    private String marca;
    private String color;

    private Concesionario concesionario;
}
