package com.api.lojavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import com.api.lojavirtual.models.Acesso;
import com.api.lojavirtual.services.AcessoService;

@Controller
public class AcessoController {
	
	@Autowired
	AcessoService acessoService;
	
	public Acesso saveAcesso(Acesso acesso) {
		return acessoService.save(acesso);
	}

}
