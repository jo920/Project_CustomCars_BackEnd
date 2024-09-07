package com.jh.car.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.jh.car.model.Pagamento;

@Repository
public interface PagamentoRepository extends JpaRepository<Pagamento,Integer> {

}
