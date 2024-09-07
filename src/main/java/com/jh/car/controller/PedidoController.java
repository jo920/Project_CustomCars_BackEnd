package com.jh.car.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.car.model.Pedido;
import com.jh.car.service.PedidoService;

import lombok.AllArgsConstructor;
@RestController
@AllArgsConstructor
public class PedidoController {

	@Autowired
	private PedidoService service;

@GetMapping("/pedido")
public List<Pedido> findAll() {
	return service.findall();
	 
}

@GetMapping("/pedido/{id}")
public Pedido findbyId(@PathVariable Long id) {
	return service.find(id);
	
}


@PostMapping("/pedido")
public Pedido insert(@RequestBody Pedido pedido) throws IOException {
	return service.insert(pedido);
}


}
