package com.tfgdaw.spring.modelos;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Obra {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	private String nombre;
	private String compositor;
	private String imagen;
	private String descripcion;
	private String audio;
	
	
	
	//Getter y Setter de Obra
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
	public String getCompositor() {
		return compositor;
	}
	public void setCompositor(String compositor) {
		this.compositor = compositor;
	}
	public String getImagen() {
		return imagen;
	}
	public void setImagen(String imagen) {
		this.imagen = imagen;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public String getAudio() {
		return audio;
	}
	public void setAudio(String audio) {
		this.audio = audio;
	}
	
	
	//Constructor y Métodos de Obra
	public Obra() {
		super();
	}
	
	public Obra(String nombre, String compositor,String imagen, String descripcion, String audio) {
		super();
		this.nombre = nombre;
		this.compositor = compositor;
		this.imagen = imagen;
		this.descripcion = descripcion;
		this.audio = audio;
		
	}
	
	public Obra(long id, String nombre, String compositor, String imagen, String descripcion, String audio ) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.compositor = compositor;
		this.imagen = imagen;
		this.descripcion = descripcion;
		
		
	}
	@Override
	public String toString() {
		return "Obra [id=" + id + ", nombre=" + nombre + ", compositor=" + compositor + ", imagen=" + imagen
				+ ", descripcion=" + descripcion + ", audio=" + audio + "]";
	}
	

	
	
	
	
	

}
