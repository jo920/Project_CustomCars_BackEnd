package com.jh.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.jh.car.model.Cliente;


@Repository
public interface ClienteRepository extends JpaRepository<Cliente,Long> {

	@Transactional(readOnly = true)
	Cliente findByCpf(String cpf);
	

}

