package com.api.lojavirtual;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.api.lojavirtual.controllers.AcessoController;
import com.api.lojavirtual.models.Acesso;

@SpringBootTest
public class AcessoTest {
	
	@Autowired
	AcessoController acessoController;
	
	@Test
	public void  saveTest() {
		
		Acesso acesso1 = new Acesso();
		acesso1.setDescricao("ROLE_ADMIN");
		
		acessoController.saveAcesso(acesso1);
		
	}

}
