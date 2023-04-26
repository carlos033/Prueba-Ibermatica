package com.controlador;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dao.Empleado;
import com.dto.DepartamentoDTO;
import com.dto.EmpleadoDTO;
import com.excepcion.ExcepcionServicio;
import com.mapas.MapeoDepartamento;
import com.mapas.MapeoEmpleado;
import com.servicio.interfaz.ServicioDepartamento;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/departamentoController")
public class ControladorDepartamento {
	@Autowired
	private ServicioDepartamento servicio;
	@Autowired
	private MapeoDepartamento mapperD;
	@Autowired
	private MapeoEmpleado mapperE;

	@PostMapping
	@ResponseBody
	@Operation(summary = "Crear un departamento", description = "insertar un departamento")
	public ResponseEntity<Void> insertarDepartamento(@RequestBody DepartamentoDTO dto) {
		servicio.crearDepartamento(mapperD.mapeoADAO(dto));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@GetMapping("/{id}")
	@ResponseBody
	@Operation(description = "listar los empleados de un departamento segun su id")
	public ResponseEntity<List<EmpleadoDTO>> listarEmpleadosXDepartamento(@PathVariable("id") int id) {
		List<EmpleadoDTO> listaEmpleadosDTO = new ArrayList<>();
		try {
			List<Empleado> listaEmpleados = servicio.listarEmpleadoXDepartamento(id);
			listaEmpleadosDTO = listaEmpleados.stream().map(mapperE::mapeoADTO).collect(Collectors.toList());

		} catch (ExcepcionServicio e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		}
		HttpHeaders httpHeaders = new HttpHeaders();
		return new ResponseEntity<>(listaEmpleadosDTO, httpHeaders, HttpStatus.OK);
	}
}
