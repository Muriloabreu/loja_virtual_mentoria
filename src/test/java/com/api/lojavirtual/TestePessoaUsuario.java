package com.api.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.lojavirtual.models.PessoaFisica;
import com.api.lojavirtual.models.PessoaJuridica;
import com.api.lojavirtual.repositories.PessoaRepository;
import com.api.lojavirtual.services.PessoaUserService;

import junit.framework.TestCase;

@SpringBootTest(classes = LojaVirtualMentoriaApplication.class)
public class TestePessoaUsuario extends TestCase {
	
	@Autowired
	private PessoaUserService pessoaUserService;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	
	@Test
	public void testCadPessoa() {
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		
		pessoaJuridica.setCnpf("111111111111111");
		pessoaJuridica.setNome("Murilo Abreu");
		pessoaJuridica.setEmail("abre.murilo@gmail.com");
		pessoaJuridica.setTelefone("11111111100");
		pessoaJuridica.setInscEstadual("111111111111111111");
		pessoaJuridica.setInscMunicipal("11111111111");
		pessoaJuridica.setNomeFantasia("Empresa AAAAAAAA");
		pessoaJuridica.setRazaoSocial("Razão aaaaaaaaaaaaaaaaaaaa");
		pessoaJuridica.setTipoPessoa("Gerente");
		
		pessoaRepository.save(pessoaJuridica);
		
		
		PessoaFisica pessoaFisica = new PessoaFisica();		
		
		pessoaFisica.setCpf("11111111111");
		pessoaFisica.setNome("Murilo Abreu");
		pessoaFisica.setEmail("abre.murilo@gmail.com");
		pessoaFisica.setTelefone("11111111100");
		
		
		
		
		
		
		
		
	}
	
	

}
