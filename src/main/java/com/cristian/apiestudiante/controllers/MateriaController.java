package com.cristian.apiestudiante.controllers;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.apiestudiante.entities.Materia;
import com.cristian.apiestudiante.services.MateriaService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MateriaController {

	@Autowired
	MateriaService materiaService;
	
	@RequestMapping(value = "materias", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Materia> materias(){
		return materiaService.materias();
	}
	@RequestMapping(value = "/crearmateria", method = RequestMethod.POST)
	public ResponseEntity<String> crearMateria(@RequestBody Materia materia) throws ClassNotFoundException{
		JSONObject resp = new JSONObject();
		materiaService.crearMateria(materia);
		resp.put("mensaje", "Se registro correctamente la materia");
		return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "materia/{ID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Materia> getMateria(Long id) throws ClassNotFoundException {
		Optional<Materia> materia = materiaService.getMateria(id);

		if (!materia.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(materia.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/eliminarMateria/{ID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarMateria(Long id) throws ClassNotFoundException {
		Optional<Materia> materia = materiaService.getMateria(id);
		JSONObject resp = new JSONObject();
		if (!materia.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		resp.put("mensaje", "Se eliminó correctamente la materia");
		materiaService.eliminarMateria(id);
		return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "actualizarMateria/{ID}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarMateria(Long id, @RequestBody Materia materia) throws ClassNotFoundException {
		Optional<Materia> _materia  = materiaService.getMateria(id);
		JSONObject resp = new JSONObject();
		if(!_materia.isPresent()) {
			resp.put("mensaje", "La materia no existe");
			return new ResponseEntity<>(resp.toString(),HttpStatus.NOT_FOUND);
		}
		materiaService.actualizarMateria(id, materia);
		resp.put("mensaje", "Se actualizó correctamente la materia");
		return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
	}
}
