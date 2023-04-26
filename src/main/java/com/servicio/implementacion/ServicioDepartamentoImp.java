package com.servicio.implementacion;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Departamento;
import com.dao.Empleado;
import com.excepcion.ExcepcionServicio;
import com.repositorio.DepartamentoRepositorio;
import com.servicio.interfaz.ServicioDepartamento;

@Service
public class ServicioDepartamentoImp implements ServicioDepartamento {
	@Autowired
	DepartamentoRepositorio repositorio;

	@Override
	public void crearDepartamento(Departamento departamento) {
		repositorio.save(departamento);
	}

	@Override
	public List<Empleado> listarEmpleadoXDepartamento(int idDepartamento) throws ExcepcionServicio {
		buscarDepartamento(idDepartamento);
		List<Empleado> listaEmpleado = repositorio.buscarEmpleadosXdepartamento(idDepartamento);
		if (listaEmpleado.isEmpty()) {
			throw new ExcepcionServicio("El empleado con ese Id no existe");
		}
		return listaEmpleado;
	}

	@Override
	public void buscarDepartamento(int id) throws ExcepcionServicio {
		repositorio.findById(id).orElseThrow(() -> new ExcepcionServicio("El departamento con ese Id no existe"));
	}
}
