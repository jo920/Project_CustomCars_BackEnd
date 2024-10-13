package com.jh.car.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.car.model.Cliente;
import com.jh.car.model.Pedido;

@Repository
public interface PedidoRepository extends JpaRepository<Pedido, Long> {
	
	
	List<Pedido> findByCliente(Cliente cliente);

}
