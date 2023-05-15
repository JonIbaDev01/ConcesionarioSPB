package com.Jonathan.Concesionario.app.dto;

import com.Jonathan.Concesionario.app.entity.Cliente;
import com.Jonathan.Concesionario.app.entity.Concesionario;
import com.Jonathan.Concesionario.app.entity.Empleado;
import lombok.Data;
import org.springframework.stereotype.Component;
import java.util.Date;

@Data
@Component
public class VentaDto {
    private int id;
    private String fecha;
    private String metPago;
    private int totalVenta;
    private String nomCliente;
    private String apellCliente;
    private String nomEmpleado;
    private String apellEmpleado;
    private int precio;
    private String color;
    private Empleado empleado;
    private Cliente cliente;
    private Concesionario concesionario;
}
