package com.ma.pedidos.domain.error;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.ma.pedidos.domain.exception.ProductoNoExistenteException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(ProductoNoExistenteException.class)
  public final ResponseEntity<CustomResponseError> handleUserNotFoundException(ProductoNoExistenteException ex, WebRequest request) {
    CustomResponseError errorDetails = new CustomResponseError(ex.getError());
    return new ResponseEntity<>(errorDetails, HttpStatus.NOT_FOUND);
  }
  
  @Override
  protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {
      List<String> errorList = ex
              .getBindingResult()
              .getFieldErrors()
              .stream()
              .map(fieldError -> fieldError.getDefaultMessage())
              .collect(Collectors.toList());
      List<CustomResponseError> errores = new ArrayList<CustomResponseError>();
      errorList.stream().forEach((e)->{
    		  CustomResponseError error = new CustomResponseError(e);
    		  errores.add(error);
      });
      CustomResponseErrorList errorCustomList = new CustomResponseErrorList(errores);
      return handleExceptionInternal(ex, errorCustomList, headers, HttpStatus.BAD_REQUEST, request);
  }

}