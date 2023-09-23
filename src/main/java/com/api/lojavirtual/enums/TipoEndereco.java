package com.api.lojavirtual.enums;


public enum TipoEndereco {
	
	COBRANCA("Cobrança"),
	ENTREGA("Entrega");
	
	
	private String descricao;
	
	/* Constructor */
	
	private TipoEndereco(String descricao) {
		this.descricao = descricao;
	}
	
	/* Accessor Methods */
	
	public String getDescricao() {
		return descricao;
	}
	
	@Override
	public String toString() {
		return this.descricao;
	}

}
