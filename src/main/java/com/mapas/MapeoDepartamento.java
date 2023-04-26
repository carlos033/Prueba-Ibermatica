package com.mapas;

import org.mapstruct.Mapper;

import com.dao.Departamento;
import com.dto.DepartamentoDTO;

@Mapper(componentModel = "spring")
public interface MapeoDepartamento {
	DepartamentoDTO mapeoADTO(Departamento dAO);

	Departamento mapeoADAO(DepartamentoDTO dTO);

}
