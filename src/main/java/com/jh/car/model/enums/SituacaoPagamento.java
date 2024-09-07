package com.jh.car.model.enums;

public enum SituacaoPagamento {

	ABERTO(1, "Pagamento em aberto"), PENDENTE(2, "Pagamento Pendente"), PAGO(3, "Pagamento efetuado com sucesso");

	private int cod;
	private String descricao;

	private SituacaoPagamento(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;

	}

	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public static SituacaoPagamento toEnum(Integer cod) {

		if (cod == null) {

			return null;
		}

		for (SituacaoPagamento x : SituacaoPagamento.values()) {

			if (cod.equals(x.getCod())) {

				return x;

			}
		}

		throw new IllegalArgumentException("ID invalido" + cod);

	}

}
