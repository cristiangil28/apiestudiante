package com.cristian.apiestudiante.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cristian.apiestudiante.entities.Matricula;
import com.cristian.apiestudiante.repositories.MatriculaRepository;

@Service
public class MatriculaService {
	
	@Autowired
	MatriculaRepository matriculaRepository;
	
	public Optional<Matricula> getMateriaMatriculada(Long materiaID, Long usuarioID){
		return matriculaRepository.getMateriaMatriculada(materiaID, usuarioID);
	}
	
	public List<Matricula> getMateriasMatriculadaEstudiante(Long usuarioID){
		return matriculaRepository.getMateriasMatriculadaEstudiante(usuarioID);
	}
}
