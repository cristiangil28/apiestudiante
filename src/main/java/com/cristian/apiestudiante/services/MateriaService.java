package com.cristian.apiestudiante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.apiestudiante.entities.Materia;
import com.cristian.apiestudiante.repositories.MateriaRepository;

@Service
public class MateriaService {
	
	@Autowired
	MateriaRepository materiaRepository;
	
	public List<Materia> materias(){
		return materiaRepository.findAll();
	}
	
	public Materia crearMateria(Materia materia) {
		return materiaRepository.save(materia);
	}
	
	public Optional<Materia> getMateria(Long id) throws ClassNotFoundException {
		return materiaRepository.findById(id);
	}
	
	public void eliminarMateria(Long id) {
		materiaRepository.deleteById(id);
	}
	
	public Materia actualizarMateria(Long id, Materia materia) {
		Materia _materia = materiaRepository.findById(id).get();
		_materia.setNombreMateria(materia.getNombreMateria());
		_materia.setCreditos(materia.getCreditos());
		
		return materiaRepository.save(_materia);
	}
}
