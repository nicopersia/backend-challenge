package com.ma.pedidos.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.PostConstruct;
import javax.sql.DataSource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Service;
import org.springframework.jdbc.core.BeanPropertyRowMapper;

import com.ma.pedidos.domain.Pedido;
import com.ma.pedidos.domain.PedidoDetalle;
import com.ma.pedidos.domain.Producto;

@Service
public class PedidoDaoImpl extends JdbcDaoSupport implements PedidoDao{
	
	@Autowired
	DataSource dataSource;
	
	public final static RowMapper<Pedido> pedidoMapper = BeanPropertyRowMapper.newInstance(Pedido.class);
	public final static RowMapper<PedidoDetalle> pedidoDetalleMapper = BeanPropertyRowMapper.newInstance(PedidoDetalle.class);
	
	@PostConstruct
	private void initialize() {
		setDataSource(dataSource);
	}

	@Transactional
	@Override
	public void crearPedido(Pedido pedido) {
		
		String sql = "INSERT INTO PEDIDOS_CABECERA " + "(id,direccion,email,telefono,horario,fecha_alta,monto_total,aplico_descuento,estado)"
				+ "	VALUES (?,?,?,?,?,?,?,?,?)";
		getJdbcTemplate().update(sql, new Object[] {pedido.getId(),pedido.getDireccion(),pedido.getEmail(),pedido.getTelefono(),pedido.getHorario(),
				pedido.getFecha(),pedido.getTotal(),pedido.isDescuento(),pedido.getEstado()});
		
		String sqlDetalle = "";
		
		for(int i=0;i<pedido.getDetalle().length;i++) {
			sqlDetalle = "INSERT INTO PEDIDOS_DETALLE " + "(id,cantidad,precio_unitario,productos_id,pedidos_cabecera_id)"
					+ "	VALUES (?,?,?,?,?)";
			getJdbcTemplate().update(sqlDetalle, new Object[] {UUID.randomUUID().toString(),pedido.getDetalle()[i].getCantidad(),
					pedido.getDetalle()[i].getImporte(),pedido.getDetalle()[i].getProducto(),pedido.getId()});
		}
		
	}

	@Override
	public Pedido listarCabecera(String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PedidoDetalle> listarDetalle(String fecha) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Pedido> listarPedidos(String fecha) {
		
			String sql = "SELECT c.id as 'ID',c.DIRECCION,c.EMAIL,c.TELEFONO,c.HORARIO,c.FECHA_ALTA AS 'FECHA',\r\n" + 
					"c.MONTO_TOTAL as 'TOTAL', c.APLICO_DESCUENTO as 'DESCUENTO',c.ESTADO,\r\n" + 
					"d.id as 'id_detalle',d.CANTIDAD,d.PRECIO_UNITARIO as 'importe',p.NOMBRE,p.ID AS 'producto' FROM PEDIDOS_CABECERA c,PEDIDOS_DETALLE d,PRODUCTOS p\r\n" + 
					"WHERE c.ID = d.PEDIDOS_CABECERA_ID AND d.PRODUCTOS_ID = p.ID AND c.FECHA_ALTA LIKE '%" + fecha + "%'";
			List<Pedido> pedidos = getJdbcTemplate().query(sql,new ResultSetExtractor<List<Pedido>>() {
				@Override
				public List<Pedido> extractData(ResultSet rs) throws SQLException, DataAccessException {
	                List<Pedido> pedidos = new ArrayList<Pedido>();
	                List<PedidoDetalle> detalles = new ArrayList<PedidoDetalle>();
	                String pedidoId = null;
	                Pedido currentPedido = null;
	                int pedidoIdx = 0;
	                int pedidoDetalleIdx = 0;
	                while (rs.next()) {
	                    if (currentPedido == null || !pedidoId.equals(rs.getString("ID"))) {
	                        pedidoId = rs.getString("ID");
	                        currentPedido = pedidoMapper.mapRow(rs, pedidoIdx++);
	                        pedidoDetalleIdx = 0;
	                        pedidos.add(currentPedido);
	                        detalles.clear();
	                    }
	                    detalles.add(pedidoDetalleMapper.mapRow(rs, pedidoDetalleIdx++));
	                    currentPedido.setDetalle(detalles.stream().toArray(PedidoDetalle[]::new));
	                }
	                return pedidos;
	            }
	
	        });
			
			return pedidos;
		
	    }

}
