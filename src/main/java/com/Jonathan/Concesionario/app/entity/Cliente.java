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
@Table(name = "clientes")
@Data
public class Cliente implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name="nombres")
    private String nombres;
    @Column (name="apellidos")
    private String apellidos;
    @Column (name="telefono")
    private int telefono;
    @Column (name="correo")
    private String correo;


    @OneToMany(mappedBy = "cliente")
    private List<Venta> listaVentas;

    @ManyToMany(cascade = {CascadeType.ALL},mappedBy="Clientes")
    private Set<Concesionario> Concesionarios=new HashSet();
}
