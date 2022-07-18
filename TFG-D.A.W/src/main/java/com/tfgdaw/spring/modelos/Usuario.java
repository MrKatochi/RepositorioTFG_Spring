package com.tfgdaw.spring.modelos;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import com.tfgdaw.spring.modelos.Usuario;

@Entity
public class Usuario {
	
	@Id
	@GeneratedValue
	private long id;

	private String nombre;
	private String password;
	@Column(unique = true)
	private String email;
	private String avatar;
	private String permisos;
	 
	//Getter y Setter de Usuario
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getAvatar() {
		return avatar;
	}
	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}
	
	public String getPermisos() {
		return permisos;
	}
	public void setPermisos(String permisos) {
		this.permisos = permisos;
	}
	
	//Constructor y Métodos de Usuario
	
	
	public Usuario() {
		super();
	}
	
	public Usuario(String nombre, String password, String email, String avatar, String permisos) {
		super();
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.permisos=permisos;
	}
	
	public Usuario(long id, String nombre, String password, String email, String avatar, String permisos) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.password = password;
		this.email = email;
		this.avatar = avatar;
		this.permisos=permisos;
	}
	
	
	@Override
	public String toString() {
		return "Usuario [id=" + id + ", nombre=" + nombre + ", password=" + password + ", email=" + email + ", avatar="
				+ avatar + ", permisos=" + permisos + "]";
	}

	
	
	
	
	


	
	
}
