package com.jh.car.model;

import java.io.Serializable;
import java.util.Objects;

import com.jh.car.model.enums.Moeda;
import com.jh.car.model.enums.TipoCarro;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;


@Entity
@Data
@AllArgsConstructor
public class Car implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/*-------> TESTE XML DE CARRO <-----------
	 *  
	 *
	 {
	 "img" : "null",
	"modelo":"Mustang GT500",
	"marca":"Ford",
	"preco":"500000",
	"ano":"2022",
	"tipo" : 1,
	"moedaCompra":"DOLAR"
	}
	 
	 ---------------------------------------------*/

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY) // uso essa annotation para o sistema usa uma coluna autoincremental e nao precisa criar uma tabela do tipo "seq" para armazenar os IDs. 
	private Long id;
	private String img; // estou implementando essa funcionalidade
	private String modelo;
	private String marca;
	private int preco;
	private String ano;
	private TipoCarro tipo;
	private Moeda moedaCompra;


	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	
	public String getImg() {
		return img;
	}

	public void setImg(String img) {
		this.img = img;
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

	public int getPreco() {
		return preco;
	}

	public void setPreco(int preco) {
		this.preco = preco;
	}

	public String getAno() {
		return ano;
	}

	public void setAno(String ano) {
		this.ano = ano;
	}

	public TipoCarro getTipo() {
		return tipo;
	}

	public void setTipo(TipoCarro tipo) {
		this.tipo = tipo;
	}

	public Moeda getMoedaCompra() {
		return moedaCompra;
	}

	public void setMoedaCompra(Moeda moedaCompra) {
		this.moedaCompra = moedaCompra;
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
		Car other = (Car) obj;
		return Objects.equals(id, other.id);
	}

}
