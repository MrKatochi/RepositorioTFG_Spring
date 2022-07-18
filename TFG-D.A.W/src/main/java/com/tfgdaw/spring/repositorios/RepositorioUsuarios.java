package com.tfgdaw.spring.repositorios;

import org.springframework.data.repository.CrudRepository;

import com.tfgdaw.spring.modelos.Usuario;

public interface RepositorioUsuarios extends CrudRepository<Usuario, Long> {

	Usuario findFirstByEmail(String username);

}
