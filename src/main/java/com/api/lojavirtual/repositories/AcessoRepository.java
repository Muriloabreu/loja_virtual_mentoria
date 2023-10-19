package com.api.lojavirtual.repositories;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.lojavirtual.models.Acesso;



@Repository
@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long>{
	
	
	

}
