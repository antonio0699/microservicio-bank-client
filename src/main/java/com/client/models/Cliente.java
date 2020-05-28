package com.client.models;

import java.sql.Date;
import java.util.List;

public class Cliente {

	
	private Long id;
	private String nombre;
	private String apellidos;
	private Date fecNacimiento;
	private String sexo;
	private List<Cuentas> cuentas;
	
	public Cliente() {}
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellidos() {
		return apellidos;
	}
	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
	public Date getFecNacimiento() {
		return fecNacimiento;
	}
	public void setFecNacimiento(Date fecNacimiento) {
		this.fecNacimiento = fecNacimiento;
	}
	public String getSexo() {
		return sexo;
	}
	public void setSexo(String sexo) {
		this.sexo = sexo;
	}


	public List<Cuentas> getCuentas() {
		return cuentas;
	}


	public void setCuentas(List<Cuentas> cuentas) {
		this.cuentas = cuentas;
	}
	
	
	
}
