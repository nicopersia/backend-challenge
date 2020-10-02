package com.ma.pedidos.service;

import java.util.List;

import com.ma.pedidos.domain.Producto;

public interface ProductoService {
	
	List<Producto> getAllProductos();
	void create(Producto producto);
	void update (Producto producto);
	Producto getProducto(String id);
	void delete(String id);
}
