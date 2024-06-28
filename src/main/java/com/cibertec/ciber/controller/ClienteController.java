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
import com.cibertec.ciber.service.ClienteService;
import com.cibertec.ciber.util.AppSettings;

@RestController
@RequestMapping("/url/cliente") //ID DEL CONTROLLER 
public class ClienteController {
    
    // CLASE CONTROLADORA 




    // llama al service 
    @Autowired
     private ClienteService service;
    


    // METODO DEL SERVICE LISTA TODO
    @GetMapping("/listarClienteTodos")
    public List<Cliente> listaTodos(){
         return service.listaTodos();
    }




    // METODO REGISTRA
    @PostMapping("/registraCliente")
	@ResponseBody
	public ResponseEntity<?> inserta(@RequestBody Cliente obj) {
		
        Map<String, Object> salida = new HashMap<>();
		try {
			Cliente objSalida = service.agregarActualizarCliente(obj);
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
	@PutMapping("/actualizaCliente")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> actualizaEjemplo(@RequestBody Cliente obj) {
		Map<String, Object> salida = new HashMap<>();
        try {
            Cliente objSalida = service.agregarActualizarCliente(obj);
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
    @DeleteMapping("/eliminaCliente/{id}")
	@ResponseBody
	public ResponseEntity<Map<String, Object>> eliminaEjemplo(@PathVariable("id") int idEjemplo) {
		Map<String, Object> salida = new HashMap<>();
		try {
			service.eliminarCliente(idEjemplo);
			salida.put("mensaje", AppSettings.MENSAJE_ELI_EXITOSO);
		} catch (Exception e) {
			e.printStackTrace();
			salida.put("mensaje", AppSettings.MENSAJE_ELI_ERROR);
		}
		return ResponseEntity.ok(salida);
	}










}