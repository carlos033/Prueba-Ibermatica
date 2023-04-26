package com.mapas;

import java.util.List;

import org.mapstruct.Mapper;

import com.dao.Empleado;
import com.dto.EmpleadoDTO;

@Mapper(componentModel = "spring")
public interface MapeoEmpleado {
	EmpleadoDTO mapeoADTO(Empleado dAO);

	Empleado mapeoADAO(EmpleadoDTO dTO);
	
	List<EmpleadoDTO> mapeoListasADTO(List<Empleado> listaDAO);

}
