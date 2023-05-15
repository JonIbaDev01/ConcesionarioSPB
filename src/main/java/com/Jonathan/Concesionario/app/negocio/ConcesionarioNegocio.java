package com.Jonathan.Concesionario.app.negocio;

import com.Jonathan.Concesionario.app.dto.ClienteDto;
import com.Jonathan.Concesionario.app.dto.ConcesionarioDto;
import com.Jonathan.Concesionario.app.entity.Cliente;
import com.Jonathan.Concesionario.app.entity.Concesionario;
import com.Jonathan.Concesionario.app.implementacion.ClienteImpl;
import com.Jonathan.Concesionario.app.implementacion.ConcesionarioImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class ConcesionarioNegocio {
    @Autowired
    ConcesionarioImpl concesionarioImpl;

    private List<ConcesionarioDto> listaDtoConcesionario;

    public List<ConcesionarioDto> encontrarTodos() {
        listaDtoConcesionario=new ArrayList<>();
        this.concesionarioImpl.encontrarTodos().forEach(concesionario -> {
            ConcesionarioDto concesionarioDto = new ConcesionarioDto();
            concesionarioDto.setId(concesionario.getId());
            concesionarioDto.setNombre(concesionario.getNombre());
            concesionarioDto.setDireccion(concesionario.getDireccion());
            concesionarioDto.setTelefono(concesionario.getTelefono());
            this.listaDtoConcesionario.add(concesionarioDto);
        });
        return this.listaDtoConcesionario;
    }

    public String guardarConcesionario (ConcesionarioDto concesionarioDto){
        Concesionario concesionario = new Concesionario();

        try{
            if (concesionarioDto.getId()!=0){
                concesionario.setId(concesionarioDto.getId());
                concesionario.setNombre(concesionarioDto.getNombre());
                concesionario.setDireccion(concesionarioDto.getDireccion());
                concesionario.setTelefono(concesionarioDto.getTelefono());
                this.concesionarioImpl.actualizarConcesionario(concesionario);
            }
            else {
                concesionario.setId(concesionarioDto.getId());
                concesionario.setNombre(concesionarioDto.getNombre());
                concesionario.setDireccion(concesionarioDto.getDireccion());
                concesionario.setTelefono(concesionarioDto.getTelefono());
                this.concesionarioImpl.crearConcesionario(concesionario);
            }
            return "Registro Exitoso";
        }
        catch(Exception e){
            return "Registro Fallido";
        }
    }
}
