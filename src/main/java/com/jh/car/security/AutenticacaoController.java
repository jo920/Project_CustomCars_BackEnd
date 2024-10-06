package com.jh.car.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.car.dto.DadosAutenticacao;
import com.jh.car.model.Usuario;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class AutenticacaoController {

	@Autowired
	private AuthenticationManager manager;

	@Autowired
	private TokenService jwtService;

	@PostMapping("/login")
	public ResponseEntity efetuarLogin(@RequestBody @Valid DadosAutenticacao dados) {

		var token = new UsernamePasswordAuthenticationToken(dados.login(), dados.senha());
		var authentication = manager.authenticate(token);

		return ResponseEntity.ok(jwtService.gerarToken((Usuario) authentication.getPrincipal()));
	}

}
