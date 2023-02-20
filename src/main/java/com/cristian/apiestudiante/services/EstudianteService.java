package com.cristian.apiestudiante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.apiestudiante.entities.Estudiante;
import com.cristian.apiestudiante.repositories.EstudianteRepository;

@Service
public class EstudianteService {

	@Autowired
	EstudianteRepository estudianteRepository;
	
	public List<Estudiante> estudiantes(){
		return estudianteRepository.findAll();
	}
	
	public Estudiante crearEstudiante(Estudiante estudiante) {
		return estudianteRepository.save(estudiante);
	}
	
	public Optional<Estudiante> getEstudiante(Long id) throws ClassNotFoundException {
		return estudianteRepository.findById(id);
	}
	
	public void eliminarEstudiante(Long id) {
		estudianteRepository.deleteById(id);
	}
	
	public Estudiante actualizarEstudiante(Long id, Estudiante estudiante) {
		Estudiante _estudiante = estudianteRepository.findById(id).get();
		_estudiante.setNombre(estudiante.getNombre());
		_estudiante.setApellidos(estudiante.getApellidos());
		
		return estudianteRepository.save(_estudiante);
	}
}
