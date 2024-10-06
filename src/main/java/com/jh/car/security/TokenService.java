package com.jh.car.security;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.jh.car.model.Usuario;

@Service
public class TokenService {

	// annotation para buscar o conteudo de uma variavel no application.properties
	@Value("${api.security.token.secret}")
	private String secret;

	public String gerarToken(Usuario usu) {
		try {
			var algoritimo = Algorithm.HMAC256(secret);
			return JWT.create()
					.withIssuer("Custom.cars")
					.withSubject(usu.getLogin().trim())
					.withClaim("id", usu.getId())
					.withExpiresAt(dataExpiracao())
					.sign(algoritimo);
		} catch (JWTCreationException exception) {
			throw new RuntimeException("erro ao gerar token", exception);
		}

	}
	
	
	public String getSubject(String tokenJWT) {
		
		try {
			var algoritimo = Algorithm.HMAC256(secret);
		    return JWT.require(algoritimo)
		        // specify any specific claim validations
		    	.withIssuer("Custom.cars")
		        // reusable verifier instance
		        .build()
		        .verify(tokenJWT).getSubject();
		        
		} catch (JWTVerificationException exception){
		    throw new RuntimeException("Token inválido ou expirado");
		}
		
	}
	
	
	

	private Instant dataExpiracao() {
		// TODO Auto-generated method stub
		return LocalDateTime.now().plusHours(2).toInstant(ZoneOffset.of("-03:00"));
	}

	
	
	
	
}
