package com.cibertec.ciber.service;

import java.util.List;
import java.util.Optional;

import com.cibertec.ciber.entity.Cliente;
import com.cibertec.ciber.entity.Producto;

public interface ProductoService {


    // CRUD PRODUCTO


       public abstract List<Producto> listaTodos(); //LISTA 


        public abstract Optional<Producto> obtenerProductoPorId(int idProducto);



        public abstract Producto agregarProducto(Producto producto);


        public abstract void eliminarProducto(int id);


    
}
