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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jh.car.dto.CarDTO;
import com.jh.car.model.Car;
import com.jh.car.service.CarService;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
public class CarController {

	@Autowired
	private CarService service;

	@GetMapping("/car")
	public List<CarDTO> findAllCar() {
		
		List<Car> list = service.findAll();
		List<CarDTO> listDto = list.stream().map(obj -> new CarDTO(obj)).collect(Collectors.toList());
      
		return listDto;
	
	}

	@GetMapping("/car/{id}")
	public Car findById(@PathVariable Long id) {
		return service.find(id);
	}

	@PostMapping("/car")
	public Car insert(@RequestBody Car carro) {
		return service.insert(carro);
	}

	@DeleteMapping("/car/{id}")
	@Transactional
	public ResponseEntity delete(@PathVariable Long id) {
		service.delete(id);	
		return ResponseEntity.noContent().build();
	}

		
}
