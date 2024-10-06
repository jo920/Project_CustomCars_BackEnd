package com.jh.car.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
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


}
