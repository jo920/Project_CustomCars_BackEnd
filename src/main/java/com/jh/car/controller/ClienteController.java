package com.jh.car.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.car.dto.ClienteDTO;
import com.jh.car.model.Cliente;
import com.jh.car.service.ClienteService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class ClienteController {

	@Autowired
	private ClienteService service;

	@GetMapping("/cliente")
	public List<ClienteDTO> findAll() {

		List<Cliente> list = service.findAll();
		List<ClienteDTO> listDto = list.stream().map(obj -> new ClienteDTO(obj)).collect(Collectors.toList());

		return listDto;
	}

	@GetMapping("/cliente/{id}")
	public Cliente findById(@PathVariable Long id) {
		return service.findById(id);
	}

	@PostMapping("/cliente")
	public ResponseEntity insert(@RequestBody Cliente cliente) throws Exception {
		 service.insert(cliente);
		 
		 return ResponseEntity.ok(cliente);	 
	}

	@PutMapping("/cliente")
	public ResponseEntity update(@RequestBody Cliente cli) {

		service.update(cli);

		return ResponseEntity.ok(cli);
	}

	@DeleteMapping("/cliente/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);
		return ResponseEntity.noContent().build();
	}

	@GetMapping("/login/{cpf}/{senha}")
	public ResponseEntity<String> Login(@PathVariable String cpf, @PathVariable String senha) {

		if (service.Login(cpf, senha)) {

			return new ResponseEntity<String>("Login Efetuado com Sucesso!", HttpStatus.OK);
		} else {

			return new ResponseEntity<String>("Falha na identificação. Verifique o usuário e senha digitado.",
					HttpStatus.BAD_REQUEST);
		}

	}

	@PutMapping("/alterasenha/{cpf}/{newSenha}")
	public ResponseEntity<String> ForgotSenha(@PathVariable String cpf, @PathVariable String newSenha) {

		if (service.ForgotPassword(cpf, newSenha)) {

			return new ResponseEntity<String>(
					"Senha alterada com sucesso. Voce será direcionado para a página de login.", HttpStatus.OK);
		} else {

			return new ResponseEntity<String>(
					"Usuário nao encontrado, verifique se as informações foram digitadas corretamente",
					HttpStatus.NOT_FOUND);
		}

	}

}
