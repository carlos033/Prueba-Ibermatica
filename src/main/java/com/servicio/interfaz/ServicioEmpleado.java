package com.servicio.interfaz;

import com.dao.Empleado;
import com.excepcion.ExcepcionServicio;

public interface ServicioEmpleado {

	public Empleado buscarEmpleado(int id) throws ExcepcionServicio;

	public void añadirEmpleado(Empleado empleado);

	public void borrarEmpleado(int id) throws ExcepcionServicio;

	public void modificarEmpleado(Empleado empleado) throws ExcepcionServicio;
}
