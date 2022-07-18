package com.tfgdaw.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfgdaw.spring.modelos.Obra;
import com.tfgdaw.spring.repositorios.RepositorioObra;

@Service
public class ServicioObra {
	@Autowired
	private RepositorioObra repositorioObra;

	
	public Obra add(Obra e) {
		repositorioObra.save(e);
		return e;
	}
	
	public List<Obra> findAll() {
		return (List<Obra>) repositorioObra.findAll();
	}
	

	public Obra findById(long id) {
		return repositorioObra.findById(id).get();
	}

	public Obra edit(Obra e) {
		repositorioObra.save(e);
		return e;
	}

	public void deleteObra(long id) {
		repositorioObra.deleteById(id);
	}
}
