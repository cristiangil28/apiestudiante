package com.cristian.apiestudiante.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cristian.apiestudiante.entities.Materia;

@Repository
public interface MateriaRepository extends JpaRepository<Materia, Long>{
	

}
