package com.cristian.apiestudiante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.apiestudiante.entities.Usuario;
import com.cristian.apiestudiante.repositories.UsuarioRepository;

@Service
public class UsuarioService {

	@Autowired
	UsuarioRepository usuarioRepository;
	
	public List<Usuario> usuarios(){
		return usuarioRepository.getEstudiantes();
	}
	
	public Usuario crearEstudiante(Usuario usuario) {
		return usuarioRepository.save(usuario);
	}
	
	public Optional<Usuario> getEstudiante(Long id) throws ClassNotFoundException {
		return usuarioRepository.findById(id);
	}
	
	public void eliminarEstudiante(Long id) {
		usuarioRepository.deleteById(id);
	}
	
	public Usuario actualizarEstudiante(Long id, Usuario usuario) {
		Usuario _estudiante = usuarioRepository.findById(id).get();
		_estudiante.setNombre(usuario.getNombre());
		_estudiante.setApellidos(usuario.getApellidos());
		_estudiante.setCorreo(usuario.getCorreo());
		_estudiante.setTelefono(usuario.getTelefono());
		_estudiante.setTipoUsuario(usuario.getTipoUsuario());
		
		return usuarioRepository.save(_estudiante);
	}
}
