package com.ma.pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ma.pedidos.domain.Producto;
import com.ma.pedidos.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@RequestMapping(value = "/productos", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void crearProducto(@RequestBody Producto producto) {
		productoService.create(producto);
		//return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.CREATED);
	}
	
}
