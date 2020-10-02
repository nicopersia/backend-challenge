package com.ma.pedidos.domain.error;

public class CustomResponseError {
	
	public CustomResponseError(String error) {
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
