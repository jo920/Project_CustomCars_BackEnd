package com.jh.car.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.car.model.Pagamento;
import com.jh.car.service.PagamentoService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class PagamentoController {

	@Autowired
	private PagamentoService service;
	

	@GetMapping("/pagamento")
	public List<Pagamento> findAll() {
		return service.findall();
		 
	}

	@GetMapping("/pagamento/{id}")
	public Pagamento findbyId(@PathVariable Integer id) {
		return service.find(id);
		
	}


	@PostMapping("/pagamento")
	public Pagamento insert(@RequestBody Pagamento pag) throws IOException {
		return service.insert(pag);
	}


}
