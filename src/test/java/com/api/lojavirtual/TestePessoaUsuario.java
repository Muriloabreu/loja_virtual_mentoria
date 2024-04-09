package com.api.lojavirtual;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.lojavirtual.controllers.PessoaController;
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
	
	@Autowired
	private PessoaController pessoaController;
	
	
	@Test
	public void testCadPessoa() throws ExceptionMentoriaJava {
		
		PessoaJuridica pessoaJuridica = new PessoaJuridica();
		
		pessoaJuridica.setCnpj("" + Calendar.getInstance().getTimeInMillis());
		pessoaJuridica.setNome("Murilo Abreu");
		pessoaJuridica.setEmail("abreu.murilo@gmail.com");
		pessoaJuridica.setTelefone("11111111100");
		pessoaJuridica.setInscEstadual("111111111111111111");
		pessoaJuridica.setInscMunicipal("11111111111");
		pessoaJuridica.setNomeFantasia("Empresa AAAAAAAA");
		pessoaJuridica.setRazaoSocial("Razão aaaaaaaaaaaaaaaaaaaa");
		pessoaJuridica.setTipoPessoa("Gerente");
		
		pessoaController.salvarPj(pessoaJuridica);
		
		
//		PessoaFisica pessoaFisica = new PessoaFisica();		
//		
//		pessoaFisica.setCpf("11111111111");
//		pessoaFisica.setNome("Murilo Abreu");
//		pessoaFisica.setEmail("abre.murilo@gmail.com");
//		pessoaFisica.setTelefone("11111111100");
		
		
		
		
		
		
		
		
	}
	
	

}
