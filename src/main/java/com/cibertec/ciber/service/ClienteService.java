package com.cibertec.ciber.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.ciber.entity.Cliente;

public interface ClienteService {



    // SERVICE INTERFACE 
    
    // METODOS CRUD 
    public abstract List<Cliente> listaTodos(); //LISTA TODO

    public abstract Optional<Cliente> obtenerClientePorId(int id);//otbiene un objeto x id 
    public abstract Cliente  agregarActualizarCliente(Cliente cliente);// registrar por obejto 
    public abstract void eliminarCliente(int id);// elimina x id

    
}
