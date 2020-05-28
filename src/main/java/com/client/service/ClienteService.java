package com.client.service;

import java.util.List;

import com.client.models.Cliente;
import com.client.models.Cuentas;

public interface ClienteService {
	
	public List<Cliente> findAll();
	public Cliente findById(Long id);
	
	public Cliente save(Cliente cliente);
	public Cuentas save(Cuentas cuentas);
	public Cliente update(Cliente cliente, Long id);
	public Cuentas update(Cuentas cuentas,Long id);
	public void deleteById(Long id);

}
