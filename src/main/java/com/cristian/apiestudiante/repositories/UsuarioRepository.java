package com.cristian.apiestudiante.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.cristian.apiestudiante.entities.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
	
	@Query(value = "select u.* from api_estudiante.usuario u where u.tipo_usuario = 'e'", nativeQuery = true)
	List<Usuario> getEstudiantes();
}
