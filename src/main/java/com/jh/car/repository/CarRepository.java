package com.jh.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jh.car.model.Car;
import com.jh.car.model.Cliente;


@Repository
public interface CarRepository extends JpaRepository<Car,Long>{
	

}
