package com.cibertec.ciber.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cibertec.ciber.entity.Cliente;
import com.cibertec.ciber.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ClienteService {
    


    // SERVICE 


    // repositorio  
    // Autowired : instancia el repositorio 
    @Autowired
    private ClienteRepository repository;



     // METODOS CRUD 

    // METODO LISTA 
    @Override
    public List<Cliente> listaTodos() {
        // metodo propio del repository 
        return repository.findAll();
    }


    // metodo obtiene por id 
    @Override
    public Optional<Cliente> obtenerClientePorId(int id) {

        return repository.findById(id);
    }


    // metodo registrar y tambien sirve pa actualizar
    @Override
    public Cliente agregarActualizarCliente(Cliente cliente) {

        return repository.save(cliente);
    }



    // metodo elimina x id
    @Override
    public void eliminarCliente(int id) {
         repository.deleteById(id);
    }
    
}