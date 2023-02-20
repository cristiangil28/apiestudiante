package com.cristian.apiestudiante.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.apiestudiante.entities.Estudiante;
import com.cristian.apiestudiante.services.EstudianteService;

@RestController
@RequestMapping("/api")
public class EstudianteController {

	@Autowired
	EstudianteService estudianteService;

	@RequestMapping(value = "estudiantes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Estudiante> estudiantes() {
		return estudianteService.estudiantes();
	}

	@RequestMapping(value = "crearestudiante", method = RequestMethod.POST)
	public Estudiante crearEstudiante(@RequestBody Estudiante estudiante) {
		return estudianteService.crearEstudiante(estudiante);
	}

	@RequestMapping(value = "estudiante/{ID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Estudiante> getEstudiante(Long id) throws ClassNotFoundException {
		Optional<Estudiante> estudiante = estudianteService.getEstudiante(id);

		if (!estudiante.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(estudiante.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "eliminarEstudiante/{ID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarEstudiante(Long id) throws ClassNotFoundException {
		Optional<Estudiante> estudiante = estudianteService.getEstudiante(id);

		if (!estudiante.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		estudianteService.eliminarEstudiante(id);
		return new ResponseEntity<>("Se eliminó correctamente el estudiante",HttpStatus.OK);
	}
	
	@RequestMapping(value = "actualizarEstudiante/{ID}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarEstudiante(Long id, @RequestBody Estudiante estudiante) throws ClassNotFoundException{
		Optional<Estudiante> _estudiante = estudianteService.getEstudiante(id);

		if (!_estudiante.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		estudianteService.actualizarEstudiante(id,estudiante);
		return new ResponseEntity<>("Se actualizó correctamente el estudiante",HttpStatus.OK);
	}
}
