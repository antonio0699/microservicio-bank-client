package com.client.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.client.models.Cliente;
import com.client.models.Cuentas;
import com.client.service.ClienteService;

@RefreshScope
@RestController
public class ClienteController {

	
	private static Logger log = org.slf4j.LoggerFactory.getLogger(ClienteController.class);
	
	@Autowired
	private Environment env;
	
	@Autowired
	@Qualifier("serviceFeing")
	private ClienteService clienteservice;
	
	@Value("${config.texto}")
	private String texto;
	
	@GetMapping("/listar")
	public List<Cliente> listar(){
		return clienteservice.findAll();
	}
	
	@GetMapping("/detalle")
	public Cliente detalle(@RequestParam Long id,@RequestParam int cantidad) {
		return clienteservice.findById(id);
	}
	
	@PostMapping("/crear")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente crear(@RequestBody Cliente cliente) {
		return clienteservice.save(cliente);
	}
	
	@PostMapping("/crearCuenta")
	@ResponseStatus(HttpStatus.CREATED)
	public Cuentas crear(@RequestBody Cuentas cuentas) {
		return clienteservice.save(cuentas);
	}
	
	@PutMapping("/editarCliente/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente editar(@RequestBody Cliente cliente,@PathVariable Long id){
		return clienteservice.update(cliente, id);
	}
	
	@PutMapping("/editarCuenta/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Cuentas editar(@RequestBody Cuentas cuentas,@PathVariable Long id){
		return clienteservice.update(cuentas, id);
	}
	
	@DeleteMapping("/eliminar/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void editar(@PathVariable Long id){
		clienteservice.deleteById(id);
	}
	
	@GetMapping("/obtener-configuracion")
	public ResponseEntity<?> obtenerConfig(@Value("${server.port}") String puerto){
		log.info(texto);
		
		Map<String,String> json = new HashMap<>();
		json.put("texto", texto);
		json.put("puerto", puerto);
		
		if(env.getActiveProfiles().length > 0 && env.getActiveProfiles()[0].equals("dev")) {
			json.put("autor.nombre", env.getProperty("config.autor.nombre"));
			json.put("autor.correo", env.getProperty("config.autor.correo"));
		}
		
		
		return new ResponseEntity<Map<String,String>>(json,HttpStatus.OK);
	}
}
