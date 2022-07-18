package com.tfgdaw.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tfgdaw.spring.modelos.Instrumento;
import com.tfgdaw.spring.repositorios.RepositorioInstrumento;

@Service
public class ServicioInstrumento {
	@Autowired
	private RepositorioInstrumento repositorioInstrumento;
	
	public Instrumento add(Instrumento e) {
		repositorioInstrumento.save(e);
		return e;
	}
	
	public List<Instrumento> findAll() {
		return (List<Instrumento>) repositorioInstrumento.findAll();
	}
	

	public Instrumento findById(long id) {
		return repositorioInstrumento.findById(id).get();
	}

	public Instrumento edit(Instrumento e) {
		repositorioInstrumento.save(e);
		return e;
	}

	public void deleteInstrumento(long id) {
		repositorioInstrumento.deleteById(id);
	}
}
