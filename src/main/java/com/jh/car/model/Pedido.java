package com.jh.car.model;

import java.io.Serializable;
import java.text.NumberFormat;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Data
@AllArgsConstructor
public class Pedido implements Serializable {

	/*
	 * ################### XML para Inserir Pedido ################### {
	   "quantidade": "5",
	   "desconto" : "0",
	   "cliente" : {"id" : 1},
	    "carro" : {"id" : 1} }
	 ################################################################ */

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // uso essa annotation para o sistema usa uma coluna autoincremental e nao precisa criar uma tabela do tipo "seq" para armazenar os IDs. 
	private Long id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm") // Estou formando a data para sair somente dia/mes e ano e a hora do
												// Pedido
	private Date DtPedido;

	private int quantidade;

	private double desconto;

	private double precoCar;

	@OneToOne
	@JoinColumn(name = "cliente_id")
	private Cliente cliente;

	@OneToOne
	@JoinColumn(name = "car_id")
	private Car carro;

	public String getValorTotal() {
	  
	  double soma = 0.0;
	  
	  soma = (getPrecoCar() * getQuantidade()) - getDesconto();
	  
	  return NumberFormat.getCurrencyInstance().format(soma); }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public double getPrecoCar() {
		return precoCar;
	}

	public void setPrecoCar(double precoCar) {
		this.precoCar = precoCar;
	}

	public Car getCarro() {
		return carro;
	}

	public void setCarro(Car carro) {
		this.carro = carro;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public double getDesconto() {
		return desconto;
	}

	public void setDesconto(double desconto) {
		this.desconto = desconto;
	}

	public Date getDtPedido() {
		return DtPedido;
	}

	public void setDtPedido(Date dtPedido) {
		DtPedido = dtPedido;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pedido other = (Pedido) obj;
		return Objects.equals(id, other.id);
	}

}
