package com.jh.car.model.enums;

public enum Moeda {

	REAL("R$", "R$"), DOLAR("USD$", "DOLAR"), EURO("EUR", "EURO");

	private String cod;
	private String descricao;

	private Moeda(String cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public String getCod() {
		return cod;
	}

	public void setCod(String cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static Moeda toEnum(Integer cod) {

		if (cod == null) {

			return null;
		}

		for (Moeda x : Moeda.values()) {

			if (cod.equals(x.getCod())) {

				return x;

			}
		}

		throw new IllegalArgumentException("ID invalido" + cod);

	}

}
