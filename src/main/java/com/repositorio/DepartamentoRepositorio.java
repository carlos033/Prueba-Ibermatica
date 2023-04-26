package com.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.dao.Departamento;
import com.dao.Empleado;
public interface DepartamentoRepositorio extends JpaRepository<Departamento, Integer> {

	@Query("Select d.listaEmpleados from Departamento d where d.id = :id")
	public List<Empleado> buscarEmpleadosXdepartamento(int id);

}
