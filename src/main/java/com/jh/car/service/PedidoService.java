package com.jh.car.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.car.model.Car;
import com.jh.car.model.Pedido;
import com.jh.car.repository.PedidoRepository;
import com.jh.car.service.exception.ObjectNotFoundException;

@Service
public class PedidoService {

	@Autowired
	private PedidoRepository repo;
	
	@Autowired
	private CarService carservice;
	

	public List<Pedido> findall() {
		return repo.findAll();
	}

	public Pedido find(Long id) {
		Optional<Pedido> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Car.class.getName()));
	}

	public Pedido insert(Pedido pedido) throws IOException {
		
				

		pedido.setId(null);
		pedido.setPrecoCar(carservice.find(pedido.getCarro().getId()).getPreco());
		pedido.setDtPedido(new Date());

		return repo.save(pedido);
	}

}
