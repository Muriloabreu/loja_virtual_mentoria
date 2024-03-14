package com.api.lojavirtual.models.dto;

import java.io.Serializable;

public class ObjetoErroDTO implements Serializable {
	
private static final long serialVersionUID = 1L;
	
	
	private String error;
	private String code;
	
	
	
	
	/*Métodos Acessores */
	
	public String getError() {
		return error;
	}
	public void setError(String error) {
		this.error = error;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}

}
