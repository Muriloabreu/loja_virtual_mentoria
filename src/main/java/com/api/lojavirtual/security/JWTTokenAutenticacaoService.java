package com.api.lojavirtual.security;

import java.io.IOException;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.api.lojavirtual.ApplicationContextLoad;
import com.api.lojavirtual.models.Usuario;
import com.api.lojavirtual.repositories.UsuarioRepository;

@Service
@Component
public class JWTTokenAutenticacaoService {
	
	/* Tem de validade do Token 2 dias 172800000 */
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
		
		/*Junta token com o prefixo, */
		String token = TOKEN_PREFIX + " " + JWT; /*Bearer 87878we8we787w8e78w78e78w7e87w*/
		
		/*Dá Resposta para a tela w para o cliente, outra API, navegador, aplicativo, javascript, outra chamada Java*/
		response.addHeader(HEADER_STRING, token); /*Authorization: Bearer 87878we8we787w8e78w78e78w7e87w*/
		
		liberacaoCors(response);
		
		/*Usado para ver no Postman para teste*/
		response.getWriter().write("{\"Authorization\": \""+token+"\"}");
		
	}
	
	
	/*Retorna o usuário validado com token ou caso nao seja valido retona null*/
	public Authentication getAuthetication(HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		String token = request.getHeader(HEADER_STRING);
		
		try {
		
		if (token != null) {
			
			String tokenLimpo = token.replace(TOKEN_PREFIX, "").trim();
			
			/*Faz a validacao do token do usuário na requisicao e obtem o USER*/
			String user = Jwts.parser().
					setSigningKey(SECRET)
					.parseClaimsJws(tokenLimpo)
					.getBody().getSubject(); /*ADMIN ou Jose*/
			
			if (user != null) {
				
				Usuario usuario = ApplicationContextLoad.
						getApplicationContext().
						getBean(UsuarioRepository.class).findUserByLogin(user);
				
				if (usuario != null) {
					return new UsernamePasswordAuthenticationToken(
							usuario.getLogin(),
							usuario.getSenha(), 
							usuario.getAuthorities());
				}
				
			}
			
		}
		
		}catch (SignatureException e) {
			
			response.getWriter().write("Token está Inválido");
			
		} catch (ExpiredJwtException e) {

			response.getWriter().write("Token está Expirado, efetue o Login novamente!");
		
		} finally {
			
			liberacaoCors(response);
		}
		
		liberacaoCors(response);
		return null;
	}
	
	
	/*Fazendo liberação contra erro de Cors no navegador*/
	private void liberacaoCors(HttpServletResponse response) {
		
		if (response.getHeader("Access-Control-Allow-Origin") == null) {
			response.addHeader("Access-Control-Allow-Origin", "*");
		}
		
		
		if (response.getHeader("Access-Control-Allow-Headers") == null) {
			response.addHeader("Access-Control-Allow-Headers", "*");
		}
		
		
		if (response.getHeader("Access-Control-Request-Headers") == null) {
			response.addHeader("Access-Control-Request-Headers", "*");
		}
		
		if (response.getHeader("Access-Control-Allow-Methods") == null) {
			response.addHeader("Access-Control-Allow-Methods", "*");
		}
		
	}
	
	
	

}
