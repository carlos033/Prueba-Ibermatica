package com.dto;

import java.io.Serializable;
import java.util.List;


public class DepartamentoDTO implements Serializable {
	private static final long serialVersionUID = 3L;
	private int id;
	private String nombreDepartamento;
	private List<EmpleadoDTO> listaEmpleados;

	public DepartamentoDTO(String nomnbreDepartamento, List<EmpleadoDTO> listaEmpleados) {
		this.nombreDepartamento = nomnbreDepartamento;
		this.listaEmpleados = listaEmpleados;
	}

	public DepartamentoDTO() {
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

	public void setNombreDepartamento(String nomnbreDepartamento) {
		this.nombreDepartamento = nomnbreDepartamento;
	}

	public List<EmpleadoDTO> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<EmpleadoDTO> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombreDepartamento=" + nombreDepartamento + ", listaEmpleados="
				+ listaEmpleados + "]";
	}

}
