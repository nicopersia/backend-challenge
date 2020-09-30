package com.ma.pedidos.service;

import java.util.List;

import com.ma.pedidos.domain.Producto;

public interface ProductoService {
	
	List<Producto> getAllProductos();
	void create(Producto producto);
	
	
}
