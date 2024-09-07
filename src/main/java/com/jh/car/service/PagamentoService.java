package com.jh.car.service;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.car.model.Car;
import com.jh.car.model.Pagamento;
import com.jh.car.repository.PagamentoRepository;
import com.jh.car.service.exception.ObjectNotFoundException;

@Service
public class PagamentoService {

	@Autowired
	private PagamentoRepository repo;

	public List<Pagamento> findall() {
		return repo.findAll();
	}

	public Pagamento find(Integer id) {
		Optional<Pagamento> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Car.class.getName()));
	}

	public Pagamento insert(Pagamento pag)throws IOException {

		pag.setId(null);
		pag.setDtPagamento(new Date());

		return repo.save(pag);
	}

}
