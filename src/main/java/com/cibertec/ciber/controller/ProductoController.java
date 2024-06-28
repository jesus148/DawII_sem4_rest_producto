package com.cibertec.ciber.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.cibertec.ciber.entity.Cliente;
import com.cibertec.ciber.entity.Producto;
import com.cibertec.ciber.service.ClienteService;
import com.cibertec.ciber.service.ProductoService;
import com.cibertec.ciber.util.AppSettings;



@RestController
@RequestMapping("/url/producto") //ID DEL CONTROLLER 
public class ProductoController {

    
        // llama al service 
    @Autowired
     private ProductoService service;



    @GetMapping("/listarProductosTodos")
    public List<Producto> listaTodos(){
         return service.listaTodos();
    }






        // METODO REGISTRA
    @PostMapping("/registraProducto")
	@ResponseBody
	public ResponseEntity<?> inserta(@RequestBody Producto obj) {
		
        Map<String, Object> salida = new HashMap<>();
		try {
			Producto objSalida = service.agregarProducto(obj);
			if (objSalida == null) {
				salida.put("mensaje", "Error al registrar");
			} else {
				salida.put("mensaje", "Registro exitoso");
			}
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", "Error al registrar");
		}
		return ResponseEntity.ok(salida);
	}





    
    
    // METODO UPDATE = al registrar solo lo difrencia el put 
    // osea el spring busca ese obejto por el id y lo encuentra modificara todo si ese objeto del front se ha modificado o sigue igual , el spring cambiara todo menos el id
	@PutMapping("/actualizaProducto")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaProducto(@RequestBody Producto obj) {
		Map<String, Object> salida = new HashMap<>();
        try {
            Producto objSalida = service.agregarProducto(obj);
            if (objSalida == null) {
                salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
            } else {
                salida.put("mensaje", AppSettings.MENSAJE_ACT_EXITOSO);
            }
        } catch (Exception e) {
            e.printStackTrace();
            salida.put("mensaje", AppSettings.MENSAJE_ACT_ERROR);
        }
        return ResponseEntity.ok(salida);
	}






    // METODO ELIMINAR POR EL ID 
    @DeleteMapping("/eliminaProducto/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaProducto(@PathVariable("id") int idProducto) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminarProducto(idProducto);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}














}
