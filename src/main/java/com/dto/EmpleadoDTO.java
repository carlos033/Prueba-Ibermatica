package com.dto;

import java.io.Serializable;

import com.dao.Departamento;

public class EmpleadoDTO implements Serializable {

	private static final long serialVersionUID = 4L;
	private int id;
	private String nombre;
	private String apellido;
	private Departamento departamento;

	public EmpleadoDTO(int id, String nombre, String apellido, Departamento departamento) {
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.departamento = departamento;
	}

	public EmpleadoDTO() {
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

	public Departamento getDepartamento() {
		return departamento;
	}

	public void setDepartamento(Departamento departamento) {
		this.departamento = departamento;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", departamento=" + departamento
				+ "]";
	}

}
