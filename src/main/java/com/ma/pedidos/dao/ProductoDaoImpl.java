package com.ma.pedidos.dao;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ma.pedidos.domain.Producto;

@Repository
public class ProductoDaoImpl extends JdbcDaoSupport implements ProductoDao {
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Override
	public List<Producto> getAllProductos() {
		return null;
	}

	@Override
	public void create(Producto producto) {
		String sql = "INSERT INTO PRODUCTOS " + "(id,nombre,descripcion_corta,descripcion_larga,precio_unitario)"
				+ "	VALUES (?,?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[] {producto.getId(),producto.getNombre(),producto.getDescripcion_corta(),producto.getDesccripcion_larga(),producto.getPrecio_unitario()});
		
	}
	
	

}
