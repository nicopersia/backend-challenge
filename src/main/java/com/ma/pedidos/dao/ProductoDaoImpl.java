package com.ma.pedidos.dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import com.ma.pedidos.domain.Producto;
import com.ma.pedidos.mapper.ProductoRowMapper;

@Repository
public class ProductoDaoImpl extends JdbcDaoSupport implements ProductoDao {
	
	@Autowired
	DataSource dataSource;
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}
	
	public Producto getProducto(String id) {
		
		Producto producto = new Producto();
		
		try {
			String sql = "SELECT * FROM PRODUCTOS WHERE id = ?";
			producto = getJdbcTemplate().queryForObject(sql, new ProductoRowMapper(), id);
			return producto;
		}catch(Exception e) {
			return producto;
		}
	}

	@Override
	public List<Producto> getAllProductos() {
		String sql = "SELECT * FROM PRODUCTOS";
		List<Map<String, Object>> rows = getJdbcTemplate().queryForList(sql);

		List<Producto> result = new ArrayList<Producto>();
		for (Map<String, Object> row : rows) {
			Producto producto = new Producto();
			producto.setId((String) row.get("id"));
			result.add(producto);
		}

		return result;
	}

	@Override
	public void create(Producto producto) {
		String sql = "INSERT INTO PRODUCTOS " + "(id,nombre,descripcion_corta,descripcion_larga,precio_unitario)"
				+ "	VALUES (?,?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[] {producto.getId(),producto.getNombre(),producto.getDescripcion_corta(),producto.getDesccripcion_larga(),producto.getPrecio_unitario()});
		
	}
	
	@Override
	public void update(Producto producto) {
		String sql = "UPDATE PRODUCTOS " + "SET nombre = ?, descripcion_corta = ?, descripcion_larga = ?, precio_unitario = ? WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] {producto.getNombre(),producto.getDescripcion_corta(),producto.getDesccripcion_larga(),producto.getPrecio_unitario(), producto.getId()});
	}
	
	@Override
	public void delete(String id) {
		String sql = "DELETE FROM PRODUCTOS WHERE id = ?";
		getJdbcTemplate().update(sql, new Object[] {id});
	}
	

}
