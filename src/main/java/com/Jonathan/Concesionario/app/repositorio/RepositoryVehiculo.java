package com.Jonathan.Concesionario.app.repositorio;
import com.Jonathan.Concesionario.app.entity.Vehiculo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVehiculo extends JpaRepository <Vehiculo,Integer> {

    @Query(value = "SELECT ve FROM Vehiculo ve WHERE ve.id=id")
    public Vehiculo encontrarporId(int id);

}
