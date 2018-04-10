package br.com.sgp.model;

import com.fasterxml.jackson.annotation.JsonValue;

public enum TipoViagem {

	INTERNACIONAL("I"),NACIONAL("N");
	
	
	private TipoViagem(String value) {
		this.value = value;
	}

	private String value;

	@JsonValue
	public final String getValue() {
		return this.value;
	}
	
	@Override
	public String toString() {
		return value;
	}

	
		
}
