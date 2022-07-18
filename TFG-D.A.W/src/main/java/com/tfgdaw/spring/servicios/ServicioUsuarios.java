package com.tfgdaw.spring.servicios;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.tfgdaw.spring.modelos.Usuario;
import com.tfgdaw.spring.repositorios.RepositorioUsuarios;

@Service
public class ServicioUsuarios {
	@Autowired
	RepositorioUsuarios repositorio;

	@Autowired
	BCryptPasswordEncoder passwordEncoder;

	public Usuario registrar(Usuario u) {
		u.setPassword(passwordEncoder.encode(u.getPassword()));
		return repositorio.save(u);
	}

	public Usuario findById(long id) {
		return repositorio.findById(id).orElse(null);
	}

	public Usuario buscarPorEmail(String email) {
		return repositorio.findFirstByEmail(email);
	}

	public Usuario add(Usuario e) {
		repositorio.save(e);
		// userDatabaseRepository.saveOrUpdate(user);
		return e;
	}

	public List<Usuario> findAll() {
		return (List<Usuario>) repositorio.findAll();
	}

	public Usuario edit(Usuario e) {
		repositorio.save(e);
		return e;
	}

	public void deleteUsuario(long id) {
		repositorio.deleteById(id);
	}

}
