package com.tfgdaw.spring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.tfgdaw.spring.modelos.Partitura;

public interface RepositorioPartitura extends CrudRepository<Partitura, Long> {
	
	 Partitura findById(long id);


}
