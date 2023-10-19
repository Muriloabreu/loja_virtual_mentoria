package com.api.lojavirtual.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.api.lojavirtual.models.Acesso;
import com.api.lojavirtual.repositories.AcessoRepository;

@Service
public class AcessoService {
	
	@Autowired
	AcessoRepository acessoRepository;
	
	@Transactional
	public  Acesso save(Acesso acesso) {
		return acessoRepository.save(acesso);
	}

}
