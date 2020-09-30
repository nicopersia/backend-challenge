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
	public List<Producto> getAllProductos() {
		return null;
	}

	@Override
	public void create(Producto producto) {
		productoDao.create(producto);
		
	}

}
