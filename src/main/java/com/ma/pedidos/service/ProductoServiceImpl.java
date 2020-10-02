package com.ma.pedidos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.pedidos.dao.ProductoDao;
import com.ma.pedidos.domain.Producto;

@Service
public class ProductoServiceImpl implements ProductoService{
	
	@Autowired
	ProductoDao productoDao;
	
	@Override
	public Producto getProducto(String id) {
		return productoDao.getProducto(id);
	}

	@Override
	public List<Producto> getAllProductos() {
		return null;
	}

	@Override
	public void create(Producto producto) {
		productoDao.create(producto);
		
	}
	
	@Override
	public void update(Producto producto) {
		productoDao.update(producto);
	}
	
	@Override
	public void delete(String id) {
		productoDao.delete(id);
	}

}
