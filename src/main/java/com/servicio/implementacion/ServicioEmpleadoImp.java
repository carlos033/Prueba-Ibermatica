package com.servicio.implementacion;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.Empleado;
import com.excepcion.ExcepcionServicio;
import com.repositorio.EmpleadoRepositorio;
import com.servicio.interfaz.ServicioEmpleado;

@Service
public class ServicioEmpleadoImp implements ServicioEmpleado {
	@Autowired
	private EmpleadoRepositorio repositorio;

	@Override
	public Empleado buscarEmpleado(int id) throws ExcepcionServicio {
		return repositorio.findById(id).orElseThrow(() -> new ExcepcionServicio("El empleado con ese Id no existe"));
	}

	@Override
	public void añadirEmpleado(Empleado empleado) {
		repositorio.save(empleado);
	}

	@Override
	public void borrarEmpleado(int id) throws ExcepcionServicio {
		Empleado empleado = buscarEmpleado(id);
		repositorio.delete(empleado);
	}

	@Override
	public void modificarEmpleado(Empleado empleado) throws ExcepcionServicio {
		Empleado empleado2 = buscarEmpleado(empleado.getId());
		empleado2.setApellido(empleado.getApellido());
		empleado2.setDepartamento(empleado.getDepartamento());
		empleado2.setNombre(empleado.getNombre());
		repositorio.save(empleado2);
	}

}
