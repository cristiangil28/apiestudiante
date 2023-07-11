package com.cristian.apiestudiante.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cristian.apiestudiante.entities.Matricula;

public interface MatriculaRepository extends JpaRepository<Matricula,Long>{
	@Query(value = "select m.* from api_estudiante.matricula m where m.id_materia = ?1 and m.idusuario = ?2", nativeQuery = true)
	Optional<Matricula>getMateriaMatriculada(Long  materiaID, Long usuarioID);
}
