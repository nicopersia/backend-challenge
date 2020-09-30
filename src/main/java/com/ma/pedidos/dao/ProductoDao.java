package com.ma.pedidos.dao;

import java.util.List;
import com.ma.pedidos.domain.Producto;

public interface ProductoDao {
	
	List<Producto> getAllProductos();
	void create(Producto producto);

}
