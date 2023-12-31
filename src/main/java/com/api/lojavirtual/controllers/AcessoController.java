package com.api.lojavirtual.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.api.lojavirtual.models.Acesso;
import com.api.lojavirtual.repositories.AcessoRepository;
import com.api.lojavirtual.services.AcessoService;

@Controller
@RestController
public class AcessoController {
	
	@Autowired
	AcessoService acessoService;
	@Autowired
	AcessoRepository acessoRepository;
	
	@ResponseBody
	@PostMapping(value = "/salvarAcesso")
	public ResponseEntity<Acesso>  saverAcesso(@RequestBody Acesso acesso) {
		
		Acesso acessoSalvo = acessoService.save(acesso);
		
		return new ResponseEntity<Acesso>(acessoSalvo, HttpStatus.OK);
	}
	
	
	@ResponseBody
	@PostMapping(value = "/deleteAcesso")
	public ResponseEntity<?>  deleteAcesso(@RequestBody Acesso acesso) {
		
		 acessoRepository.deleteById(acesso.getId());
		
		return new ResponseEntity("Acesso removido!" ,HttpStatus.OK);
	}
	
	@ResponseBody
	@DeleteMapping(value = "/deleteAcessoPorId/{id}")
	public ResponseEntity<?>  deleteAcessoPorId(@PathVariable("id") Long id) {
		
		 acessoRepository.deleteById(id);
		
		return new ResponseEntity("Acesso removido!" ,HttpStatus.OK);
	}
	
	@ResponseBody
	@GetMapping(value = "/obterAcesso/{id}")
	public ResponseEntity<Acesso>  obterAcesso(@PathVariable("id")  Long id) {
		
		Acesso acesso = acessoRepository.findById(id).get();
		
		return new ResponseEntity<Acesso>(acesso ,HttpStatus.OK);
	}
	
}
