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

import com.cristian.apiestudiante.entities.Usuario;
import com.cristian.apiestudiante.services.UsuarioService;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200")
public class UsuarioController {

	@Autowired
	UsuarioService usuarioService;

	@RequestMapping(value = "estudiantes", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Usuario> usuarios() {
		return usuarioService.usuarios();
	}
	@RequestMapping(value = "/crearestudiante", method = RequestMethod.POST)
	public ResponseEntity<String> crearEstudiante(@RequestBody Usuario usuario) {
		Optional<Usuario> _usuario = usuarioService.getEstudianteDocumento(usuario.getDocumento());
		JSONObject resp = new JSONObject();
		if(_usuario.isPresent()) {
			resp.put("mensaje", "El número de documento ya esta registrado");
			return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
		}
		
		resp.put("mensaje", "El estudiante se creo con exito");
		usuarioService.crearEstudiante(usuario);
	
		return new ResponseEntity<>(resp.toString(), HttpStatus.OK);
	}

	@RequestMapping(value = "estudiante/{ID}", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Usuario> getEstudiante(Long id) throws ClassNotFoundException {
		Optional<Usuario> usuario = usuarioService.getEstudiante(id);

		if (!usuario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<>(usuario.get(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "eliminarEstudiante/{ID}", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> eliminarEstudiante(Long id) throws ClassNotFoundException {
		Optional<Usuario> usuario = usuarioService.getEstudiante(id);
		JSONObject resp = new JSONObject();
		if (!usuario.isPresent()) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		usuarioService.eliminarEstudiante(id);
		resp.put("mensaje", "Se eliminó correctamente el estudiante");
		return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
	}
	
	@RequestMapping(value = "actualizarEstudiante/{ID}", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<String> actualizarEstudiante(Long id, @RequestBody Usuario usuario) throws ClassNotFoundException{
		Optional<Usuario> _estudiante = usuarioService.getEstudiante(id);
		JSONObject resp = new JSONObject();
		if (!_estudiante.isPresent()) {
			resp.put("error", "Usuario no encontrado");
			return new ResponseEntity<>(resp.toString(),HttpStatus.NOT_FOUND);
		}
		usuarioService.actualizarEstudiante(id,usuario);
		
		resp.put("mensaje", "Se actualizó correctamente el estudiante");
		return new ResponseEntity<>(resp.toString(),HttpStatus.OK);
	}
}
