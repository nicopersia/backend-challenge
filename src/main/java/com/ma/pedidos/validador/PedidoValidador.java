package com.ma.pedidos.validador;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.ma.pedidos.domain.dto.PedidoDTO;

public class PedidoValidador implements ConstraintValidator<PedidoDomicilio, String> {

    @Override
    public boolean isValid(String domicilio, ConstraintValidatorContext context) {
        if(domicilio == null) {
        	return false;
        }
        return  true;
    }

}