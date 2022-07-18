package com.tfgdaw.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfgdaw.spring.modelos.Partitura;
import com.tfgdaw.spring.repositorios.RepositorioPartitura;

@Service
public class ServicioPartitura {
	@Autowired
	private RepositorioPartitura repositorioPartitura;
	
	public Partitura add(Partitura e) {
		repositorioPartitura.save(e);
		return e;
	}
	
	public List<Partitura> findAll() {
		return (List<Partitura>) repositorioPartitura.findAll();
	}
	

	public Partitura findById(long id) {
		return repositorioPartitura.findById(id);
	}

	public Partitura edit(Partitura e) {
		repositorioPartitura.save(e);
		return e;
	}

	public void deletePartitura(long id) {
		repositorioPartitura.deleteById(id);
	}
	
	public void viewPartitura(long id) {
		repositorioPartitura.findById(id);
	}
	
}
