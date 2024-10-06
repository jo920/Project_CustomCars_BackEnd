package com.jh.car.security;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@Component // estou informando que essa classe é uma classe generica
public class SecurityFilter extends OncePerRequestFilter {

	@Autowired
	private TokenService token;
	
	@Autowired
	private UsuarioRepository repo;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
			throws ServletException, IOException {

		System.out.print("CHAMANDO");
		
		var tokenJWT = recuperarToken(request);

		if (tokenJWT != null) {
			var subject = token.getSubject(tokenJWT); // busco o subject onde consta o usuário 
			var usuario = repo.findByLogin(subject); // verifico se o usuario existe no banco
			var authentication = new UsernamePasswordAuthenticationToken(usuario,null,usuario.getAuthorities()); // cria o DTO do Spring com base nas informações buscadas 
			
			SecurityContextHolder.getContext().setAuthentication(authentication); // realizado a autenticação 
			
			System.out.print("LOGADO!!!");
		
		}

		filterChain.doFilter(request, response); // utiliza o filterChain para ser liberado o proximo filtro de
													// requisicao.

	}

	private String recuperarToken(HttpServletRequest request) {
		var authorizationHeader = request.getHeader("Authorization");

		if (authorizationHeader != null) {

			return authorizationHeader.replace("Bearer ", "");
		}

		return null;
	}

}
