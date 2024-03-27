package com.api.lojavirtual.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.api.lojavirtual.models.PessoaJuridica;

@Transactional
public interface PessoaRepository extends JpaRepository<PessoaJuridica, Long>{
	
	

}
