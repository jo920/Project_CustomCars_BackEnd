package com.jh.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jh.car.model.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

	  Cliente findByLogin(String login);

}
