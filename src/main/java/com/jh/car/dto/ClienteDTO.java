package com.jh.car.dto;

import java.io.Serializable;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;

import org.hibernate.validator.constraints.Length;

import com.jh.car.model.Cliente;

public class ClienteDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Long id;

	@NotEmpty(message = " O preenchimento do campo nome é obrigatório!")
	@Length(min = 10, max = 60, message = "O campo nome deve ter no minimo 10 caracteres e o maximo de 60 caracteres.")
	private String nome;

	@NotEmpty(message = " O preenchimento do campo email é obrigatório!")
	@Email(message = "O email informado, está inválido")
	private String email;
	
	@NotEmpty(message = " O preenchimento do campo cpf é obrigatório!")
	private String cpf;
	
	private String senha;

	public ClienteDTO() {

	}

	public ClienteDTO(Cliente obj) {

		id = obj.getId();
		nome = obj.getName();
		email = obj.getEmail();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	
	
	
	
}
