package com.jh.car.dto;

import java.io.Serializable;

import javax.validation.constraints.NotEmpty;

import com.jh.car.model.Car;



public class CarDTO implements Serializable {

	
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message="O campo nao pode ser nulo.Favor preencher")// estou declarando que o campo nao pode ser nulo
	private String modelo;
	
	@NotEmpty(message="O campo nao pode ser nulo.Favor preencher")// estou declarando que o campo nao pode ser nulo
	private String marca;
	
	@NotEmpty(message="O campo nao pode ser nulo.Favor preencher")// estou declarando que o campo nao pode ser nulo
	private double preco;
	
	@NotEmpty(message="O campo nao pode ser nulo.Favor preencher")// estou declarando que o campo nao pode ser nulo
	private double ano;
	
	public CarDTO() {
		
	}
	
	
	public CarDTO(Car obj){
		
		id = obj.getId();
		modelo = obj.getModelo();
		marca = obj.getMarca();
		preco = obj.getPreco();
		ano   = obj.getPreco();
		
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public double getAno() {
		return ano;
	}

	public void setAno(double ano) {
		this.ano = ano;
	}
	
	
	
}
