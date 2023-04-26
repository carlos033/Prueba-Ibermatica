package com.repositorio;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dao.Empleado;

public interface EmpleadoRepositorio extends JpaRepository<Empleado, Integer> {
    
}
