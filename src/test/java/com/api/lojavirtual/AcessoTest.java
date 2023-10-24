package com.api.lojavirtual;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.lojavirtual.controllers.AcessoController;
import com.api.lojavirtual.models.Acesso;
import com.api.lojavirtual.repositories.AcessoRepository;

import junit.framework.TestCase;

@SpringBootTest
public class AcessoTest extends TestCase {
	
	@Autowired
	AcessoController acessoController;
	
	@Autowired
	AcessoRepository acessoRepository;
	
	@Test
	public void  saveTest() {
		
		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_GERENTE");
		
		/*TESTE UNITÁRIO PARA SABER SE O Id ESTÁ NULLO*/
		assertEquals(true, acesso.getId() == null);
		
		/*GRAVOU NO BANCO*/
		acessoController.saverAcesso(acesso).getBody();
		
		/*TESTE UNITÁRIO PARA SABER SE O Id ESTÁ NULLO*/
		assertEquals(true, acesso.getId() > 0);
		
		/*TESTE UNITÁRIO PARA VALIDAR SE FOI SALVO DE FORMA CORRETA  */
		assertEquals("ROLE_GERENTE", acesso.getDescricao());
		
		/*TESTE DE CARREGAMENTO*/
		
		Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();
		
		assertEquals(acesso.getId(), acesso2.getId());
		
		/*TESTE DE DELETE*/
		
		acessoRepository.deleteById(acesso2.getId());
		acessoRepository.flush(); /*Roda esse SQL de delete no banco de dados*/
		
Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null);
		
		assertEquals(true, acesso3 == null);
		
		
		/*Teste de query*/
		
		acesso = new Acesso();
		
		acesso.setDescricao("ROLE_ALUNO");
		
		acesso = acessoController.saverAcesso(acesso).getBody();
		
		List<Acesso> acessos = acessoRepository.buscarAcessoDesc("ALUNO".trim().toUpperCase());
		
		assertEquals(1, acessos.size());
		
		acessoRepository.deleteById(acesso.getId());
		
	}

}
