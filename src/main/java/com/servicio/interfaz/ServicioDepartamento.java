package com.servicio.interfaz;

import java.util.List;

import com.dao.Departamento;
import com.dao.Empleado;
import com.excepcion.ExcepcionServicio;

public interface ServicioDepartamento {
	public void crearDepartamento(Departamento departamento);

	public List<Empleado> listarEmpleadoXDepartamento(int idDepartamento) throws ExcepcionServicio;

	public void buscarDepartamento(int id) throws ExcepcionServicio;
}
