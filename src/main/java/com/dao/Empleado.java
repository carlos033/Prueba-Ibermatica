package com.dao;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import io.swagger.v3.oas.annotations.media.Schema;

@Table
@Entity
public class Empleado implements Serializable {

	private static final long serialVersionUID = 1L;
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private int idE;
	@Schema(example = "Carlos")
	private String nombre;
	@Schema(example = "Diaz")
	private String apellido;
	@JoinColumn(name = "id", referencedColumnName = "id")
	@ManyToOne(optional = false)
	private Departamento departamento;

	public Empleado(int id, String nombre, String apellido, Departamento departamento) {
		this.idE = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.departamento = departamento;
	}

	public Empleado() {
	}

	public int getId() {
		return idE;
	}

	public void setId(int id) {
		this.idE = id;
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
		return "Empleado [id=" + idE + ", nombre=" + nombre + ", apellido=" + apellido + ", departamento=" + departamento
				+ "]";
	}

}
