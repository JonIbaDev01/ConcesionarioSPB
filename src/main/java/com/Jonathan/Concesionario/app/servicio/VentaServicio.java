package com.Jonathan.Concesionario.app.servicio;

import com.Jonathan.Concesionario.app.entity.Venta;

import java.util.List;

public interface VentaServicio {

    public List<Venta> encontrarTodos();

    public Venta encontrarporId(int id);
    public void actualizarVenta(Venta venta);
    public void crearVenta(Venta venta);
    public void eliminarVenta(int id);
}
