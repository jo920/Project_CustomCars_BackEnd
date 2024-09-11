package com.jh.car.model.enums;

import com.fasterxml.jackson.annotation.JsonCreator;

public enum TipoCarro {
	
	IMPORTADO(1,"Veículo Importado"),
	NACIONAL(2,"Veículo Nacional");
	
	private int cod;
	private String descricao;
	
	private TipoCarro(int cod,String descricao) {
		
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao() {
		return descricao;
	}
	
	public static TipoCarro toEnum(Integer cod) {
		
		if(cod==null) {
			
		return null; 
		}
  
	
	
	for (TipoCarro x : TipoCarro.values()) {
		
		if(cod.equals(x.getCod())) {
			
			return x; 
			
		}
	}
	
	throw new IllegalArgumentException("ID invalido"+ cod);
	
  }	

}
