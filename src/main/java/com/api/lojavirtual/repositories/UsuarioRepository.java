package com.api.lojavirtual.repositories;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.api.lojavirtual.models.Usuario;

public interface UsuarioRepository extends CrudRepository<Usuario, Long> {

	@Query(value = "SELECT u FROM Usuario u WHERE u.login = ?1")
	Usuario findUserByLogin(String login);
}
