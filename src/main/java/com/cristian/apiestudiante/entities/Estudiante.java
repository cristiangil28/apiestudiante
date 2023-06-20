package com.cristian.apiestudiante.entities;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "estudiante")
@Model
public class Estudiante {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idestudiante")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;

	public Estudiante() {
		// TODO Auto-generated constructor stub
	}

	public Estudiante(Long id, String nombre, String apellidos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	@Override
	public String toString() {
		return "Estudiante [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + "]";
	}
	
}
