package com.dto;

import java.io.Serializable;

public class DepartamentoDTOsinList implements Serializable {
	private static final long serialVersionUID = 3L;
	private int id;
	private String nombreDepartamento;

	public DepartamentoDTOsinList(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}

	public DepartamentoDTOsinList() {
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNombreDepartamento() {
		return nombreDepartamento;
	}

	public void setNombreDepartamento(String nombreDepartamento) {
		this.nombreDepartamento = nombreDepartamento;
	}
	
	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombreDepartamento=" + nombreDepartamento + "]";
	}

}

