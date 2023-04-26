package com.dao;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Table
@Entity
public class Departamento implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int id;
	@Schema(example = "Ventas")
	private String nombreDepartamento;
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "departamento")
	private List<Empleado> listaEmpleados;

	public Departamento(String nombreDepartamento, List<Empleado> listaEmpleados) {
		this.nombreDepartamento = nombreDepartamento;
		this.listaEmpleados = listaEmpleados;
	}

	public Departamento() {
		this.listaEmpleados = new ArrayList<>();
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

	public List<Empleado> getListaEmpleados() {
		return listaEmpleados;
	}

	public void setListaEmpleados(List<Empleado> listaEmpleados) {
		this.listaEmpleados = listaEmpleados;
	}

	@Override
	public String toString() {
		return "Departamento [id=" + id + ", nombreDepartamento=" + nombreDepartamento + ", listaEmpleados="
				+ listaEmpleados + "]";
	}
}
