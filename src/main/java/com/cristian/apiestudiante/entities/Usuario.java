package com.cristian.apiestudiante.entities;

import javax.enterprise.inject.Model;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "usuario")
@Model
public class Usuario {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idusuario")
	private Long id;
	
	@Column(name="nombre")
	private String nombre;
	
	@Column(name = "apellidos")
	private String apellidos;
	
	@Column(name = "correo")
	private String correo;
	
	@Column(name = "telefono")
	private String telefono;
	
	@Column(name = "tipo_usuario")
	private String tipoUsuario;
	
	@Column(name = "documento", unique = true)
	private String documento;

	public Usuario() {
		// TODO Auto-generated constructor stub
	}

	public Usuario(Long id, String nombre, String apellidos) {
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
	
	
	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}
	
	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", apellidos=" + apellidos + ", correo=" + correo
				+ ", telefono=" + telefono + ", tipoUsuario=" + tipoUsuario + ", documento=" + documento + "]";
	}
}
