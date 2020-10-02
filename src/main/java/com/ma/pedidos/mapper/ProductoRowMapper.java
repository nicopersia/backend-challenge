package com.ma.pedidos.mapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import com.ma.pedidos.domain.Producto;

public class ProductoRowMapper implements RowMapper<Producto>{

		@Override
		public Producto mapRow(ResultSet rs, int rowNum) throws SQLException {
			 Producto p = new Producto();
			 p.setId(rs.getString("ID"));
			 p.setDesccripcion_larga(rs.getString("DESCRIPCION_LARGA"));
		     p.setDescripcion_corta(rs.getString("DESCRIPCION_CORTA"));
		     p.setNombre(rs.getString("NOMBRE"));
		     p.setPrecio_unitario(rs.getDouble("PRECIO_UNITARIO"));
		     return p;
		}

}
