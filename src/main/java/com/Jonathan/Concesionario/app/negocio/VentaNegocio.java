package com.Jonathan.Concesionario.app.negocio;

import com.Jonathan.Concesionario.app.dto.VentaDto;
import com.Jonathan.Concesionario.app.entity.Concesionario;
import com.Jonathan.Concesionario.app.entity.Venta;
import com.Jonathan.Concesionario.app.implementacion.VentaImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
@Component
public class VentaNegocio {
    @Autowired
    VentaImpl ventaImpl;

    private List<VentaDto> listaDtoVentas;

    public List<VentaDto> encontrarTodos() {
        listaDtoVentas=new ArrayList<>();
        this.ventaImpl.encontrarTodos().forEach(venta -> {
            VentaDto ventaDto = new VentaDto();

            ventaDto.setId(venta.getId());
            ventaDto.setFecha(venta.getFecha());
            ventaDto.setMetPago(venta.getMetPago());
            ventaDto.setTotalVenta(venta.getTotalVenta());
            ventaDto.setNomCliente(venta.getNomCliente());
            ventaDto.setApellCliente(venta.getApellCliente());
            ventaDto.setNomEmpleado(venta.getNomEmpleado());
            ventaDto.setApellEmpleado(venta.getApellEmpleado());
            ventaDto.setPrecio(venta.getPrecio());
            ventaDto.setColor(venta.getColor());

            this.listaDtoVentas.add(ventaDto);
        });
        return this.listaDtoVentas;
    }

    public String guardarVenta (VentaDto ventaDto){
        Venta venta = new Venta();

        try{
            if (ventaDto.getId()!=0){
                venta.setId(ventaDto.getId());
                venta.setFecha(ventaDto.getFecha());
                venta.setMetPago(ventaDto.getMetPago());
                venta.setTotalVenta(ventaDto.getTotalVenta());
                venta.setNomCliente(ventaDto.getNomCliente());
                venta.setApellCliente(ventaDto.getApellCliente());
                venta.setNomEmpleado(ventaDto.getNomEmpleado());
                venta.setApellEmpleado(ventaDto.getApellEmpleado());
                venta.setPrecio(ventaDto.getPrecio());
                venta.setColor(ventaDto.getColor());

                venta.setEmpleado(ventaDto.getEmpleado());
                venta.setCliente(ventaDto.getCliente());
                venta.setConcesionario(ventaDto.getConcesionario());

                this.ventaImpl.actualizarVenta(venta);
            }
            else {
                venta.setId(ventaDto.getId());
                venta.setFecha(ventaDto.getFecha());
                venta.setMetPago(ventaDto.getMetPago());
                venta.setTotalVenta(ventaDto.getTotalVenta());
                venta.setNomCliente(ventaDto.getNomCliente());
                venta.setApellCliente(ventaDto.getApellCliente());
                venta.setNomEmpleado(ventaDto.getNomEmpleado());
                venta.setApellEmpleado(ventaDto.getApellEmpleado());
                venta.setPrecio(ventaDto.getPrecio());
                venta.setColor(ventaDto.getColor());

                venta.setEmpleado(ventaDto.getEmpleado());
                venta.setCliente(ventaDto.getCliente());
                venta.setConcesionario(ventaDto.getConcesionario());

                this.ventaImpl.crearVenta(venta);
            }
            return "Registro Exitoso";
        }
        catch(Exception e){
            return "Registro Fallido";
        }
    }

    public String eliminarVenta(int id){
        Venta venta;
        try{
            this.ventaImpl.eliminarVenta(id);
            return "Eliminacion exitosa";
        }catch (Exception e){
            e.printStackTrace();
            return "Eliminacion Fallida";
        }
    }
}
