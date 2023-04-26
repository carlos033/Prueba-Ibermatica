package com.controlador;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.dto.EmpleadoDTO;
import com.excepcion.ExcepcionServicio;
import com.mapas.MapeoEmpleado;
import com.servicio.interfaz.ServicioEmpleado;

import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/empleadoControler")
public class ControladorEmpleado {
	@Autowired
	private ServicioEmpleado servicio;
	@Autowired
	private MapeoEmpleado mapperE;

	@PostMapping
	@ResponseBody
	@Operation(summary = "Crear un empleado", description = "insertar un empleado")
	public ResponseEntity<Void> insertarEmpleado(@RequestBody EmpleadoDTO dto) {
		servicio.añadirEmpleado(mapperE.mapeoADAO(dto));
		return new ResponseEntity<>(HttpStatus.OK);
	}

	@DeleteMapping(value = "/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Operation(description = "Borra por id")
	public void eliminarCita(@PathVariable("id") int id) {
		try {
			servicio.borrarEmpleado(id);
		} catch (ExcepcionServicio ex) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, ex.getMessage());
		}
	}

	@GetMapping("/{id}")
	@ResponseBody
	public ResponseEntity<EmpleadoDTO> buscarVuelo(@PathVariable("id") int id) {
		try {
			return new ResponseEntity<>(mapperE.mapeoADTO(servicio.buscarEmpleado(id)), HttpStatus.OK);
		} catch (Exception e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		}

	}

	@PutMapping
	@ResponseBody
	@Operation(description = "Modificarr un empleado")
	public ResponseEntity<Void> modificarEmpleado(@RequestBody EmpleadoDTO dto) {
		try {
			servicio.modificarEmpleado(mapperE.mapeoADAO(dto));
		} catch (ExcepcionServicio e) {
			throw new ResponseStatusException(HttpStatus.CONFLICT, e.getMessage());
		}
		return new ResponseEntity<>(HttpStatus.OK);
	}

}
