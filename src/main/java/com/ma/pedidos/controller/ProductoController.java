package com.ma.pedidos.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.ma.pedidos.domain.Producto;
import com.ma.pedidos.domain.exception.ProductoNoExistenteException;
import com.ma.pedidos.service.ProductoService;

@RestController
public class ProductoController {

	@Autowired
	ProductoService productoService;
	
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.GET)
	@ResponseStatus(HttpStatus.OK)
	public Producto obtenerProducto(@PathVariable("id") String id) {
		return productoExistente(id);
	}
	
	@RequestMapping(value = "/productos", method = RequestMethod.POST)
	@ResponseStatus(HttpStatus.CREATED)
	public void crearProducto(@RequestBody Producto producto) {
		productoService.create(producto);
	}
	
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.PUT)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void modificarProducto(@PathVariable("id") String id, @RequestBody Producto producto) {
		productoExistente(id);
		producto.setId(id);
		productoService.update(producto);
	}
	
	@RequestMapping(value = "/productos/{id}", method = RequestMethod.DELETE)
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void borrarProducto(@PathVariable("id") String id) {
		productoExistente(id);
		productoService.delete(id);
	}
	
	private Producto productoExistente(String id) {
		Producto producto = productoService.getProducto(id);
		if(producto.getId() == null)
			throw new ProductoNoExistenteException("Producto no existente");
		return producto;
	}
	
}
