package com.cristian.apiestudiante.controllers;

import java.util.List;
import java.util.Optional;

import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.cristian.apiestudiante.entities.Materia;
import com.cristian.apiestudiante.entities.Matricula;
import com.cristian.apiestudiante.entities.Usuario;
import com.cristian.apiestudiante.services.MateriaService;
import com.cristian.apiestudiante.services.MatriculaService;
import com.cristian.apiestudiante.services.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class MatriculaController {
	
	@Autowired
	UsuarioService usuarioService;
	
	@Autowired
	MateriaService materiaService;
	
	@Autowired
	MatriculaService matriculaService;
	
	@RequestMapping(value = "matricula/{materiaID}/{usuarioID}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> matricularMateria(Long materiaID, Long usuarioID) throws ClassNotFoundException {
		JSONObject resp = new JSONObject();
		if (materiaID == null || usuarioID == null) {
			resp.put("error", "Datos nulos");
			return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
		}
		Optional<Matricula> matricula = matriculaService.getMateriaMatriculada(materiaID, usuarioID);
		if(matricula.isPresent()) {
			resp.put("error", "La materia ya se encuentra matriculada");
			return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
		}
		Optional<Usuario> estudiante = usuarioService.getEstudiante(usuarioID);
		Optional <Materia> materia = materiaService.getMateria(materiaID);
		if(estudiante.isPresent() && materia.isPresent()) {
			Materia _materia = materia.get();
			Usuario _estudiante = estudiante.get();
			_estudiante.addMateria(_materia);
			usuarioService.actualizarEstudiante(usuarioID,_estudiante);
		}
		resp.put("mensaje", "Se matriculo correctamente la materia");
		return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "matricula/{usuarioID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Matricula> getMateriasMatriculadas(Long usuarioID){
		return matriculaService.getMateriasMatriculadaEstudiante(usuarioID);
	}
}
