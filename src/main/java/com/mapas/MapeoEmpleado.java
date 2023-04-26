package com.mapas;

import org.mapstruct.Mapper;

import com.dao.Empleado;
import com.dto.EmpleadoDTO;
import com.dto.EmpleadoDTOSinList;

@Mapper(componentModel = "spring")
public interface MapeoEmpleado {

	EmpleadoDTOSinList mapeoADTOSinList(Empleado dAO);

	Empleado mapeoADAO(EmpleadoDTO dTO);
}
