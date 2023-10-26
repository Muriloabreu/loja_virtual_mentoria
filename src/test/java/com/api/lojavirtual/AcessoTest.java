package com.api.lojavirtual;

import java.util.List;

import org.junit.Ignore;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.DefaultMockMvcBuilder;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import com.api.lojavirtual.controllers.AcessoController;
import com.api.lojavirtual.models.Acesso;
import com.api.lojavirtual.repositories.AcessoRepository;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import junit.framework.TestCase;

@SpringBootTest
public class AcessoTest extends TestCase {

	@Autowired
	AcessoController acessoController;

	@Autowired
	AcessoRepository acessoRepository;
	
	@Autowired
	private WebApplicationContext wac;
	
	/*Teste do end-point de salvar*/
	@Test
	public void testRestApiCadastroAcesso() throws JsonProcessingException, Exception {
		
	    DefaultMockMvcBuilder builder = MockMvcBuilders.webAppContextSetup(this.wac);
	    MockMvc mockMvc = builder.build();
	    
	    Acesso acesso = new Acesso();
	    
	    acesso.setDescricao("ROLE_COMPRADOR");
	    
	    ObjectMapper objectMapper = new ObjectMapper();
	    
	    ResultActions retornoApi = mockMvc
	    						 .perform(MockMvcRequestBuilders.post("/salvarAcesso")
	    						 .content(objectMapper.writeValueAsString(acesso))
	    						 .accept(MediaType.APPLICATION_JSON)
	    						 .contentType(MediaType.APPLICATION_JSON));
	    
	    System.out.println("Retorno da API: " + retornoApi.andReturn().getResponse().getContentAsString());
	    
	    /*Conveter o retorno da API para um obejto de acesso*/
	    
	    Acesso objetoRetorno = objectMapper.
	    					   readValue(retornoApi.andReturn().getResponse().getContentAsString(),
	    					   Acesso.class);
	    
	    assertEquals(acesso.getDescricao(), objetoRetorno.getDescricao());
	    
	    
	    
	    
	}

	//@Test
	@Ignore
	public void saveTest() {

		Acesso acesso = new Acesso();
		acesso.setDescricao("ROLE_GERENTE");

		/* TESTE UNITÁRIO PARA SABER SE O Id ESTÁ NULLO */
		assertEquals(true, acesso.getId() == null);

		/* GRAVOU NO BANCO */
		acessoController.saverAcesso(acesso).getBody();

		/* TESTE UNITÁRIO PARA SABER SE O Id ESTÁ NULLO */
		assertEquals(true, acesso.getId() > 0);

		/* TESTE UNITÁRIO PARA VALIDAR SE FOI SALVO DE FORMA CORRETA */
		assertEquals("ROLE_GERENTE", acesso.getDescricao());

		
		/* TESTE DE CARREGAMENTO */		
		Acesso acesso2 = acessoRepository.findById(acesso.getId()).get();

		assertEquals(acesso.getId(), acesso2.getId());

		/* TESTE DE DELETE */
		acessoRepository.deleteById(acesso2.getId());
		acessoRepository.flush(); /* Roda esse SQL de delete no banco de dados */

		Acesso acesso3 = acessoRepository.findById(acesso2.getId()).orElse(null);

		assertEquals(true, acesso3 == null);
		
		
		/* TESTE DE QUERY */		
		
		acesso = new Acesso();

		acesso.setDescricao("ROLE_ALUNO");

		acesso = acessoController.saverAcesso(acesso).getBody();

		List<Acesso> acessos = acessoRepository.buscarAcessoDesc("ALUNO".trim().toUpperCase());

		assertEquals(1, acessos.size());

		acessoRepository.deleteById(acesso.getId());

	}

}
