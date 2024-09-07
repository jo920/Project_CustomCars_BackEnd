package com.jh.car.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.jh.car.model.enums.SituacaoPagamento;

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
public class Pagamento implements Serializable {

	/*
	 * ################### XML para Inserir Pedido ###################
	  {"banco": "341",
 	   "agencia":"1234",
 	   "contacorrente":"458795",
 	   "pedido" : {"id" : 1},
 	   "situacao": "PAGO"}	    
	 ################################################################*/
	
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)// uso essa annotation para o sistema usa uma coluna autoincremental e nao precisa criar uma tabela do tipo "seq" para armazenar os IDs. 
	private Integer id;

	@JsonFormat(pattern = "dd/MM/yyyy HH:mm") // Estou formando a data para sair somente dia/mes e ano e a hora do Pedido
	private Date DtPagamento;

	private int banco;
	private int agencia;
	private int contacorrente;

	 
	@OneToOne
	@JoinColumn(name = "pedido_id")
	private Pedido pedido;
	
	
	private SituacaoPagamento situacao;


	public Integer getId() {
		return id;
	}


	public void setId(Integer id) {
		this.id = id;
	}


	public Date getDtPagamento() {
		return DtPagamento;
	}


	public void setDtPagamento(Date dtPagamento) {
		DtPagamento = dtPagamento;
	}


	public int getBanco() {
		return banco;
	}


	public void setBanco(int banco) {
		this.banco = banco;
	}


	public int getAgencia() {
		return agencia;
	}


	public void setAgencia(int agencia) {
		this.agencia = agencia;
	}


	public int getContacorrente() {
		return contacorrente;
	}


	public void setContacorrente(int contacorrente) {
		this.contacorrente = contacorrente;
	}


	public Pedido getPedido() {
		return pedido;
	}


	public void setPedido(Pedido pedido) {
		this.pedido = pedido;
	}


	public SituacaoPagamento getSituacao() {
		return situacao;
	}


	public void setSituacao(SituacaoPagamento situacao) {
		this.situacao = situacao;
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
		Pagamento other = (Pagamento) obj;
		return Objects.equals(id, other.id);
	}
	
	
	
	
	
}
