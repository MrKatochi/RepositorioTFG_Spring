package com.tfgdaw.spring.modelos;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Instrumento {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombre;
	private String imagen;
	private String tipo;
	
	
	//Getter y Setter de Instrumento
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
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	
	
	//Constructor y Métodos de Instrumento 
	public Instrumento() {
		super();
	}
	
	public Instrumento(String nombre, String imagen, String tipo) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.tipo = tipo;
	}
	
	public Instrumento(long id, String nombre, String imagen, String tipo) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.tipo = tipo;
	}
	
	
}