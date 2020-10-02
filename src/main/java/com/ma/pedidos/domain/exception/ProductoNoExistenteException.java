package com.ma.pedidos.domain.exception;

public class ProductoNoExistenteException extends RuntimeException{
	
	private static final long serialVersionUID = 1L;

	public ProductoNoExistenteException(String error){
		this.error = error;
	}
	
	private String error;

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
