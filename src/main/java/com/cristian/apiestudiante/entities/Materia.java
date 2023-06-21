package com.cristian.apiestudiante.entities;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "materia")
@Model
public class Materia {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_materia")
	private Long id;
	
	@Column(name ="nombre_materia")
	private String nombreMateria;
	
	@Column(name = "creditos")
	private int creditos;
	
	public Materia() {
		// TODO Auto-generated constructor stub
	}
	
	public Materia(Long id, String nombreMateria, int creditos) {
		super();
		this.id = id;
		this.nombreMateria = nombreMateria;
		this.creditos = creditos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombreMateria() {
		return nombreMateria;
	}

	public void setNombreMateria(String nombreMateria) {
		this.nombreMateria = nombreMateria;
	}

	public int getCreditos() {
		return creditos;
	}

	public void setCreditos(int creditos) {
		this.creditos = creditos;
	}

	@Override
	public String toString() {
		return "Materia [id=" + id + ", nombreMateria=" + nombreMateria + ", creditos=" + creditos + "]";
	}
	
}
