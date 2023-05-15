package com.Jonathan.Concesionario.app.implementacion;
import com.Jonathan.Concesionario.app.entity.Vehiculo;
import com.Jonathan.Concesionario.app.repositorio.RepositoryVehiculo;
import com.Jonathan.Concesionario.app.servicio.VehiculoServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehiculoImpl implements VehiculoServicio {

    @Autowired
    RepositoryVehiculo repositoryVehiculo;

    @Override
    public List<Vehiculo> encontrarTodos() {
        return this.repositoryVehiculo.findAll();
    }

    @Override
    public Vehiculo encontrarporId(int id) {
        Vehiculo vehiculo = this.repositoryVehiculo.encontrarporId(id);
        return vehiculo;
    }

    @Override
    public void actualizarVehiculo(Vehiculo vehiculo) {

        if (vehiculo.getId()!=0){
            this.repositoryVehiculo.save(vehiculo);
        }
    }

    @Override
    public void crearVehiculo(Vehiculo vehiculo) {
        this.repositoryVehiculo.save(vehiculo);
    }

    @Override
    public void eliminarVehiculo(int id) {
        Vehiculo vehiculo = this.repositoryVehiculo.encontrarporId(id);

        if (vehiculo != null){
            this.repositoryVehiculo.save(vehiculo);
        }

    }
}
