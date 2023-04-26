package com.dto;

import java.io.Serializable;

public class EmpleadoDTOSinList implements Serializable {

	private static final long serialVersionUID = 6L;
	private int id;
	private String nombre;
	private String apellido;
	private DepartamentoDTOsinList departamento;

	public EmpleadoDTOSinList(int id, String nombre, String apellido, DepartamentoDTOsinList departamento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.departamento = departamento;
	}

	public EmpleadoDTOSinList() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public DepartamentoDTOsinList getDepartamento() {
		return departamento;
	}

	public void setDepartamento(DepartamentoDTOsinList departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", departamento=" + departamento
				+ "]";
	}

}
