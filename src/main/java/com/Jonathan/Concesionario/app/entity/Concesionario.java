package com.Jonathan.Concesionario.app.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity
@Table(name = "concesionarios")
@Data
public class
Concesionario implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column (name="nombre")
    private String nombre;
    @Column (name="direccion")
    private String direccion;
    @Column (name="telefono")
    private int telefono;

    /*
    @JsonIgnore
    @OneToMany(mappedBy = "idConcesionario")
    private List<Empleado> listaEmpleados;

    @JsonIgnore
    @OneToMany(mappedBy = "idConcesionario")
    private List<Venta> listaVentas;

    @JsonIgnore
    @OneToMany(mappedBy = "idConcesionario")
    private List<Vehiculo> listaVehiculos;

    @ManyToMany
    @JoinTable(name="concesio_clientes",
        joinColumns = @JoinColumn(name="idCliente"),
        inverseJoinColumns = @JoinColumn(name="idConcesionario"))
    private List<Cliente> listaClientes;*/

    // Relacion entre tablas
    @OneToMany(mappedBy = "concesionario")
    private List<Empleado> listaEmpleados;

    @OneToMany(mappedBy = "concesionario")
    private List<Venta> listaVentas;

    @OneToMany(mappedBy = "concesionario")
    private List<Vehiculo> listaVehiculos;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(name="concesio_clientes",
            joinColumns=@JoinColumn(name="idConcesionario", referencedColumnName = "id"),
            inverseJoinColumns=@JoinColumn(name="idClientes", referencedColumnName = "id"))
    private Set<Cliente> Clientes;



}
