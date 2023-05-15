package com.Jonathan.Concesionario.app.implementacion;

import com.Jonathan.Concesionario.app.entity.Venta;
import com.Jonathan.Concesionario.app.repositorio.RepositoryVenta;
import com.Jonathan.Concesionario.app.servicio.VentaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class VentaImpl implements VentaServicio {
    @Autowired
    RepositoryVenta repositoryVenta;

    @Override
    public List<Venta> encontrarTodos() {
        return this.repositoryVenta.findAll();
    }

    @Override
    public Venta encontrarporId(int id) {
        Venta venta = this.repositoryVenta.encontrarporId(id);
        return venta;
    }

    @Override
    public void actualizarVenta(Venta venta) {

        if (venta.getId()!=0){
            this.repositoryVenta.save(venta);
        }
    }

    @Override
    public void crearVenta(Venta venta) {
        this.repositoryVenta.save(venta);
    }

    @Override
    public void eliminarVenta(int id) {
        Venta venta = this.repositoryVenta.encontrarporId(id);

        if (venta != null){
            this.repositoryVenta.save(venta);
        }

    }
}
