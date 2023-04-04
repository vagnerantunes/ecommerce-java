package com.app.ecommerce.enums;

public enum AtivoBloqStatus {

	ATIVO(1, "Ativo"),
	BLOQUEADO(2, "Bloqueado");
	
	private int cod;
	private String descricao;
	
	private AtivoBloqStatus(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}
	
	public int getCod() {
		return cod;
	}
	
	public String getDescricao () {
		return descricao;
	}
	
	public static AtivoBloqStatus toEnum(Integer cod) {
		
		if (cod == null) {
			return null;
		}
		
		for (AtivoBloqStatus x : AtivoBloqStatus.values()) {
			if (cod.equals(x.getCod())) {
				return x;
			}
		}
		
		throw new IllegalArgumentException("Id inválido: " + cod);
	}
}
