package com.ma.pedidos.domain.error;

import java.util.List;

public class CustomResponseErrorList {
	
	public CustomResponseErrorList(List<CustomResponseError> errores) {
		this.errores = errores;
	}
	
	private List<CustomResponseError> errores;

	public List<CustomResponseError> getErrores() {
		return errores;
	}

	public void setErrores(List<CustomResponseError> errores) {
		this.errores = errores;
	}
	
	

}
