package com.client.clients;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.client.models.Cliente;
import com.client.models.Cuentas;

@FeignClient(name = "microservicio-bank")
public interface ClienteRest {

	@GetMapping("/listar")
	public List<Cliente> listar();
	
	@GetMapping("/detalle")
	public Cliente detalle(@RequestParam Long id);
	
	@PostMapping("/agregarCliente")
	public Cliente crear(@RequestBody Cliente cliente);
	
	@PostMapping("/agregarCuenta")
	public Cuentas crear(@RequestBody Cuentas cuentas);
	
	@PutMapping("/editarCliente/{id}")
	public Cliente editar(@RequestBody Cliente cliente,@PathVariable Long id);
	
	@PutMapping("/editarCuenta/{id}")
	public Cuentas editar(@RequestBody Cuentas cuentas,@PathVariable Long id);
	
	@DeleteMapping("/eliminarCliente/{id}")
	public void eliminar(@PathVariable Long id);
}
