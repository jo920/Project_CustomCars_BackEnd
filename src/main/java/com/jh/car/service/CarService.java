package com.jh.car.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jh.car.model.Car;
import com.jh.car.repository.CarRepository;
import com.jh.car.service.exception.ObjectNotFoundException;

@Service
public class CarService {

	@Autowired
	private CarRepository repo;

	// metodo para buscar todos os carros
	public List<Car> findAll() {

		return repo.findAll();
	}

	// metodo para buscar o carro por ID
	public Car find(Long id) {
		Optional<Car> obj = repo.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException(
				"Objeto não encontrado! Id: " + id + ", Tipo: " + Car.class.getName()));
	}

	public Car insert(Car carro) {
		carro.setId(null);
		return repo.save(carro);
	}

	public void delete(Long id) {
		find(id);
		repo.deleteById(id);
	}
	
	
}
