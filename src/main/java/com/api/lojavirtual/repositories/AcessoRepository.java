package com.api.lojavirtual.repositories;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.api.lojavirtual.models.Acesso;


@Transactional
public interface AcessoRepository extends JpaRepository<Acesso, Long>{
	
	@Query("select a from Acesso a where upper(trim(a.descricao)) like %?1%")
	List<Acesso> buscarAcessoDesc(String desc);
	

}
