package com.api.lojavirtual;

import java.util.Calendar;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.lojavirtual.controllers.PessoaController;
import com.api.lojavirtual.enums.TipoEndereco;
import com.api.lojavirtual.models.Endereco;
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
		pessoaJuridica.setEmail("teste01.emp01@gmail.com");
		pessoaJuridica.setTelefone("11111111100");
		pessoaJuridica.setInscEstadual("111111111111111111");
		pessoaJuridica.setInscMunicipal("11111111111");
		pessoaJuridica.setNomeFantasia("Empresa AAAAAAAA");
		pessoaJuridica.setRazaoSocial("Razão aaaaaaaaaaaaaaaaaaaa");
		pessoaJuridica.setTipoPessoa("Gerente");
		
		
		Endereco endereco1 = new Endereco();
		endereco1.setRuaLogra("AV. Visconde A");
		endereco1.setCep("10010-000");
		endereco1.setBairro("Centro");
		endereco1.setNumero("597");
		endereco1.setComplemento("14 Andar, Sala 1402");
		endereco1.setCidade("Recife");
		endereco1.setUf("PE");
		endereco1.setEmpresa(pessoaJuridica);
		endereco1.setPessoa(pessoaJuridica);
		endereco1.setTipoEndereco(TipoEndereco.COBRANCA);
		
		Endereco endereco2 = new Endereco();
		endereco2.setRuaLogra("AV. Visconde A");
		endereco2.setCep("10010-000");
		endereco2.setBairro("Centro");
		endereco2.setNumero("597");
		endereco2.setComplemento("14 Andar, Sala 1402");
		endereco2.setCidade("Recife");
		endereco2.setUf("PE");
		endereco2.setEmpresa(pessoaJuridica);
		endereco2.setPessoa(pessoaJuridica);
		endereco2.setTipoEndereco(TipoEndereco.COBRANCA);
		
		pessoaJuridica.getEnderecos().add(endereco1);
		pessoaJuridica.getEnderecos().add(endereco2);
		
		
		pessoaController.salvarPj(pessoaJuridica).getBody();
		
		assertEquals(true, pessoaJuridica.getId() > 0);
		
		//Para testar se salvou os dois endereços
		for (Endereco endereco : pessoaJuridica.getEnderecos()) {
			assertEquals(true, endereco.getId() > 0);
		}
		
		//Para testar se salvou dois endereços
		assertEquals(2, pessoaJuridica.getEnderecos().size());
		
		
		
		

		
		
		
		
		
		
		
	}
	
	

}
