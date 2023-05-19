package com.Jonathan.Concesionario.app.implementacion;

import com.Jonathan.Concesionario.app.entity.Cliente;
import com.Jonathan.Concesionario.app.repositorio.RepositoryCliente;
import com.Jonathan.Concesionario.app.servicio.ClienteServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteImpl implements ClienteServicio {
    @Autowired
    RepositoryCliente repositoryCliente;

    @Override
    public List<Cliente> encontrarTodos() {
        return this.repositoryCliente.findAll();
    }

    @Override
    public Cliente encontrarporId(int id) {
        Cliente cliente = this.repositoryCliente.encontrarporId(id);
        return cliente;
    }

    @Override
    public void actualizarCliente(Cliente cliente) {

        if (cliente.getId()!=0){
            this.repositoryCliente.save(cliente);
        }
    }

    @Override
    public void crearCliente(Cliente cliente) {
        this.repositoryCliente.save(cliente);
    }

    @Override
    public void eliminarCliente(int id) {
        repositoryCliente.deleteById(id);


    }
}
