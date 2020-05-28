package com.client.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.client.clients.ClienteRest;
import com.client.models.Cliente;
import com.client.models.Cuentas;

@Service("serviceFeing")
public class ClienteServiceImpl implements ClienteService{

	@Autowired
	private ClienteRest cliente;

	@Override
	public List<Cliente> findAll() {
		// TODO Auto-generated method stub
		return cliente.listar().stream().collect(Collectors.toList());
	}

	@Override
	public Cliente findById(Long id) {
		// TODO Auto-generated method stub
		return cliente.detalle(id);
	}

	@Override
	public Cliente save(Cliente cliente) {
		// TODO Auto-generated method stub
		return this.cliente.crear(cliente);
	}

	@Override
	public Cliente update(Cliente cliente, Long id) {
		// TODO Auto-generated method stub
		return this.cliente.editar(cliente, id);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		cliente.eliminar(id);
	}

	@Override
	public Cuentas save(Cuentas cuentas) {
		// TODO Auto-generated method stub
		return cliente.crear(cuentas);
	}

	@Override
	public Cuentas update(Cuentas cuentas, Long id) {
		// TODO Auto-generated method stub
		return cliente.editar(cuentas, id);
	}
}
