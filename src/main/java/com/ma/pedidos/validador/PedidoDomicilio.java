package com.ma.pedidos.validador;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

/**
 * Comprueba que la suma de los caracteres del codigo este dentro del rango valido
 */

@Documented
@Constraint(validatedBy = PedidoValidador.class)
@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface PedidoDomicilio {
    String message() default "la direccion no puede estar nula";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}  
