package com.Jonathan.Concesionario.app.repositorio;

import com.Jonathan.Concesionario.app.entity.Venta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryVenta extends JpaRepository <Venta,Integer> {
    @Query(value = "SELECT v FROM Venta v WHERE v.id=id")
    public Venta encontrarporId(int id);
}
