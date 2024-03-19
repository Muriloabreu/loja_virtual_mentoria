package com.api.lojavirtual;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.lojavirtual.models.PessoaFisica;
import com.api.lojavirtual.services.PessoaUserService;

import junit.framework.TestCase;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class TestePessoaUsuario extends TestCase {
	
	@Autowired
	private PessoaUserService pessoaUserService;
	
	
	
	public void testCadPessoa() {
		
		PessoaFisica pessoaFisica = new PessoaFisica();
		
		pessoaFisica.setCpf("11111111111");
		pessoaFisica.setNome("Murilo Abreu");
		pessoaFisica.setEmail("abre.murilo@gmail.com");
		pessoaFisica.setTelefone("11111111100");
		
		
		
		
		
		
		
	}
	
	

}
