package com.api.lojavirtual.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletResponse;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

@Service
@Component
public class JWTTokenAutenticacaoService {
	
	/* Tem de validade do Token 2 dias */
	private static final long EXPIRATION_TIME = 172800000;
	
	/* Uma senha unica para compor a autenticacao e ajudar com o JWT */
	private static final String SECRET = "SenhaExtremamenteSecreta";
	
	/* Prefixo padrão de Token */
	private static final String TOKEN_PREFIX = "Bearer";
	
	private static final String HEADER_STRING = "Authorization";
	
	/* Gerando token de autenticado e adiconando ao cabeçalho e resposta Http */
	public void addAuthentication(HttpServletResponse response , String username) throws IOException {
		
		/*Montagem do Token*/
		String JWT = Jwts.builder() /*Chama o gerador de Token*/
				        .setSubject(username) /*Adicona o usuario*/
				        .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) /*Tempo de expiração*/
				        .signWith(SignatureAlgorithm.HS512, SECRET).compact(); /*Compactação e algoritmos de geração de senha*/
		
		/*Junta token com o prefixo*/
		String token = TOKEN_PREFIX + " " + JWT; /*Bearer 87878we8we787w8e78w78e78w7e87w*/
		
		/*Dá Resposta para a tela w para o cliente, outra API, navegador, aplicativo, javascript, outra chamada Java*/
		response.addHeader(HEADER_STRING, token); /*Authorization: Bearer 87878we8we787w8e78w78e78w7e87w*/
		
		/*Usado para ver no Postman para teste*/
		response.getWriter().write("{\"Authorization\": \""+token+"\"}");
		
	}

}
