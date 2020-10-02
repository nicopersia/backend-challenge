package com.ma.pedidos.service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ma.pedidos.dao.PedidoDao;
import com.ma.pedidos.dao.ProductoDao;
import com.ma.pedidos.domain.Pedido;
import com.ma.pedidos.domain.PedidoDetalle;
import com.ma.pedidos.domain.Producto;
import com.ma.pedidos.domain.dto.PedidoDTO;
import com.ma.pedidos.constantes.Constantes;
@Service
public class PedidoServiceImpl implements PedidoService{
	
	@Autowired
	PedidoDao pedidoDAO;
	
	@Autowired
	ProductoDao productoDAO;

	@Override
	public Pedido crearPedido(Pedido pedido) {
		
		double cantidadItems = 0;
		
		for(int i=0; i<pedido.getDetalle().length; i++) {
			Producto p = productoDAO.getProducto(pedido.getDetalle()[i].getProducto());
			pedido.getDetalle()[i].setImporte(p.getPrecio_unitario());
			pedido.getDetalle()[i].setNombre(p.getNombre());
			pedido.setTotal(pedido.getTotal() + (p.getPrecio_unitario() * pedido.getDetalle()[i].getCantidad()));
			cantidadItems += pedido.getDetalle()[i].getCantidad();
		}
		
		if(aplicaDescuento(cantidadItems))
			pedido.setTotal(pedido.getTotal() - pedido.getTotal() * Constantes.PORCENTAJE_DESCUENTO);
			pedido.setDescuento(true);
		
		pedido.setId(UUID.randomUUID().toString());
		pedido.setFecha(getMysqlHora());
		pedido.setEstado(Constantes.ESTADO_PENDIENTE);
		pedidoDAO.crearPedido(pedido);
		return pedido;
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
		return pedidoDAO.listarPedidos(fecha);
	}
	
	private String getMysqlHora() {
		LocalDateTime ldt = LocalDateTime.now();
		return DateTimeFormatter.ofPattern("yyyy-MM-dd", Locale.ENGLISH).format(ldt);
	}
	
	private boolean aplicaDescuento(double cantidadItems) {
		if(cantidadItems > Constantes.CANTIDAD_ITEMS_DESCUENTO)
			return true;
		
		return false;
	}

}
