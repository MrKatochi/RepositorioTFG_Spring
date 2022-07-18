package com.tfgdaw.spring.modelos;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@EntityListeners(AuditingEntityListener.class)
public class Partitura {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	private String nombre;
	private String imagen;
	private String archivo;
	private String instrumento;
	private String obra;
	private long usuario;
	
	
	//Getter y Setter de Partitura
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
	public String getArchivo() {
		return archivo;
	}
	public void setArchivo(String archivo) {
		this.archivo = archivo;
	}
	
	public String getInstrumento() {
		return instrumento;
	}
	public void setInstrumento(String instrumento) {
		this.instrumento = instrumento;
	}
	public String getObra() {
		return obra;
	}
	public void setObra(String obra) {
		this.obra = obra;
	}
	public long getUsuario() {
		return usuario;
	}
	public void setUsuario(long usuario) {
		this.usuario = usuario;
	}
	//Constructor y Métodos de Partitura
	public Partitura() {
		super();
	}
	
	
	public Partitura(String nombre, String imagen, String archivo, String instrumento, String obra,
			long usuario) {
		super();
		this.nombre = nombre;
		this.imagen = imagen;
		this.archivo = archivo;
		this.instrumento = instrumento;
		this.obra = obra;
		this.usuario = usuario;
	}
	
	public Partitura(long id, String nombre, String imagen, String archivo, String instrumento, String obra,
			long usuario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.imagen = imagen;
		this.archivo = archivo;
		this.instrumento = instrumento;
		this.obra = obra;
		this.usuario = usuario;
	}
}

	
	